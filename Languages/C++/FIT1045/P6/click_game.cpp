#include "splashkit.h"

// ============================================================
// Constants
// ---------
// Window and circle settings used throughout the program.
// ============================================================
const int WINDOW_WIDTH  = 800;
const int WINDOW_HEIGHT = 600;
const int CIRCLE_RADIUS = 50;

// Progress bar position and size
const int BAR_X      = 10;
const int BAR_Y      = 10;
const int BAR_WIDTH  = WINDOW_WIDTH - 20;
const int BAR_HEIGHT = 30;


// ============================================================
// read_integer
// ------------
// Displays a prompt and reads a validated integer from the
// terminal. Keeps asking until a valid whole number is entered.
// ============================================================
int read_integer(string prompt)
{
    string input;

    while (true)
    {
        write(prompt);
        input = read_line();

        bool is_valid = !input.empty();
        for (int i = 0; i < input.length(); i++)
        {
            if (i == 0 && input[i] == '-')
            {
                continue;
            }
            if (!isdigit(input[i]))
            {
                is_valid = false;
                break;
            }
        }

        if (is_valid)
        {
            return stoi(input);
        }

        write_line("Please enter a whole number");
    }
}


// ============================================================
// target_hit
// ----------
// Returns true if the user has clicked the mouse AND
// the mouse position is inside the circle target.
//
// Parameters:
//   circle_x : centre x position of the circle
//   circle_y : centre y position of the circle
//   radius   : radius of the circle
//
// Uses SplashKit's:
//   mouse_clicked() - checks if the left mouse button was clicked
//   point_in_circle() - checks if a point is inside a circle
// ============================================================
bool target_hit(double circle_x, double circle_y, int radius)
{
    // Only count a hit if the left mouse button was clicked this frame
    if (!mouse_clicked(LEFT_BUTTON))
    {
        return false;
    }

    // Check if the mouse position is inside the circle
    // point_in_circle takes a point and a circle struct
    point_2d  mouse_pos  = mouse_position();
    circle    target_circle = circle_at(circle_x, circle_y, radius);

    return point_in_circle(mouse_pos, target_circle);
}


// ============================================================
// draw_progress
// -------------
// Draws a progress bar at the given position and size.
// The bar fills from left to right based on 'percent' (0.0-1.0).
//
// Parameters:
//   x, y          : top-left corner of the bar
//   bar_width     : total width of the bar (outline)
//   bar_height    : height of the bar
//   percent       : how full the bar is (0.0 = empty, 1.0 = full)
// ============================================================
void draw_progress(int x, int y, int bar_width, int bar_height, double percent)
{
    // Calculate how wide the filled portion should be
    int filled_width = (int)(bar_width * percent);

    // Draw the filled (green) portion
    fill_rectangle(COLOR_GREEN, x, y, filled_width, bar_height);

    // Draw the empty (dark grey) portion
    fill_rectangle(COLOR_DARK_GRAY, x + filled_width, y, bar_width - filled_width, bar_height);

    // Draw a white outline around the whole bar
    draw_rectangle(COLOR_WHITE, x, y, bar_width, bar_height);
}


// ============================================================
// random_position
// ---------------
// Returns a random position for the circle centre, ensuring
// the circle stays fully within the window boundaries.
// ============================================================
double random_x_position()
{
    // Keep circle inside the window: from radius to window_width - radius
    return rnd(CIRCLE_RADIUS, WINDOW_WIDTH - CIRCLE_RADIUS);
}

double random_y_position()
{
    // Keep circle below the progress bar area
    int min_y = BAR_Y + BAR_HEIGHT + CIRCLE_RADIUS + 10;
    return rnd(min_y, WINDOW_HEIGHT - CIRCLE_RADIUS);
}


// ============================================================
// main
// ----
// Entry point. Reads how many targets to hit, then runs the
// game loop until the player clicks that many targets.
// ============================================================
int main()
{
    // --- Welcome and input ---
    write_line("Welcome to target click.");
    write_line("");

    int target_count = read_integer("What is your target score: ");
    write_line("");
    write_line("Click " + to_string(target_count) + " targets to end the game.");

    // --- Open the game window ---
    open_window("Click Game", WINDOW_WIDTH, WINDOW_HEIGHT);

    // --- Set up initial circle position ---
    double circle_x = random_x_position();
    double circle_y = random_y_position();

    // --- Track how many targets have been hit ---
    int hits = 0;

    // --- Game loop: runs until player hits all targets ---
    while (!quit_requested() && hits < target_count)
    {
        // Process any window/mouse events this frame
        process_events();

        // Check if the user clicked the target this frame
        if (target_hit(circle_x, circle_y, CIRCLE_RADIUS))
        {
            hits++;

            // Move the circle to a new random position for the next target
            circle_x = random_x_position();
            circle_y = random_y_position();
        }

        // --- Drawing ---
        clear_screen(COLOR_BLACK);

        // Draw the progress bar (percent = hits / target_count)
        double percent = (double)hits / (double)target_count;
        draw_progress(BAR_X, BAR_Y, BAR_WIDTH, BAR_HEIGHT, percent);

        // Draw the circle target
        fill_circle(color_steel_blue(), circle_x, circle_y, CIRCLE_RADIUS);
        draw_circle(COLOR_WHITE, circle_x, circle_y, CIRCLE_RADIUS);

        // Refresh screen at 60fps
        refresh_screen(60);
    }

    // --- Game over ---
    write_line("Well done! You hit " + to_string(hits) + " targets!");

    return 0;
}