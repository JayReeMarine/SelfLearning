#include "splashkit.h"
#include "click_game_utilities.h"

const int WINDOW_WIDTH = 800;
const int WINDOW_HEIGHT = 600;
const float RADIUS = 50;

int main()
{
    write_line("Welcome to target click.");

    write_line();
    int target_score = confirm_int_safe("What is your target score: ");

    write_line("Click: " + to_string(target_score) + " targets to end the game");

    open_window("Target click game", WINDOW_WIDTH, WINDOW_HEIGHT);

    int targets_hit = 0;

    float circle_x;
    float circle_y;
    float radius = RADIUS;
    new_target(circle_x, circle_y, radius);

    while (!quit_requested() && targets_hit < target_score)
    {
        process_events();

        if (mouse_clicked(LEFT_BUTTON) &&
        circle_clicked(mouse_x(), mouse_y(), circle_x, circle_y, radius))
        {
            targets_hit++;
            new_target(circle_x, circle_y, radius);
        }

        clear_screen(COLOR_WHITE);

        fill_rectangle(COLOR_LIGHT_GRAY, 50, 20, 700, 69);

        float fill_width = (targets_hit / float(target_score)) * 700;

        fill_rectangle(COLOR_LIME, 50, 20, fill_width, 69);

        fill_circle(COLOR_BLUE, circle_x, circle_y, radius);

        refresh_screen();
    }
    return 0;
}
