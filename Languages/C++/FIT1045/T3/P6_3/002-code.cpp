#include "splashkit.h"

int confirm_int_safe(string prompt)
{
    while (true)
    {
        write(prompt);
        string user_entry = read_line();

        if (is_integer(user_entry))
        {
            return to_integer(user_entry);
        }
        else
        {
            write_line("Please enter a whole number.");
        }
    }
}

bool circle_clicked(float mx, float my, float cx, float cy, float radius)
{
    float dx = mx - cx;
    float dy = my - cy;

    return square_root(dx * dx + dy * dy) <= radius;
}

void new_target(float &x, float &y, float radius)
{
    x = rnd(radius, 800 - radius);
    y = rnd(radius, 600 - radius);
}

void draw_progress_bar(int targets_hit, int target_score)
{
    fill_rectangle(COLOR_LIGHT_GRAY, 50, 20, 700, 69);

    float fill_width = (targets_hit / float(target_score)) * 700;
    fill_rectangle(COLOR_LIME, 50, 20, fill_width, 69);
}