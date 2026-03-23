#include "splashkit.h"

int main()
{
    // All variables and constants declared
    int player_radius = 50;

    // Open and create window with a clear white screen
    open_window("Project Window", 1200, 1200);
    clear_screen(COLOR_WHITE);

    while (!quit_requested()) // Until the user wishes to end the program on their own
    {
        process_events();

        // All commands related to the screen and the player radius
        if (key_typed(C_KEY))
        {
            clear_screen(random_color());
        }
        else if (key_typed(S_KEY))
        {
            player_radius = 10;
        }
        else if (key_typed(M_KEY))
        {
            player_radius = 50;
        }
        else if (key_typed(L_KEY))
        {
            player_radius = 100;
        }

        // Draw circle at mouse when clicked
        if (mouse_clicked(LEFT_BUTTON))
        {
            fill_circle(random_color(), mouse_x(), mouse_y(), player_radius);
        }

        refresh_screen(60);
    }
}