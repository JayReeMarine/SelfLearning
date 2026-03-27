#include <splashkit.h>

// Name used to identify the game timer within SplashKit
const string GAME_TIMER_NAME = "GameTimer";

// Screen dimensions
const int SCREEN_WIDTH  = 800;
const int SCREEN_HEIGHT = 600;

// Spider appearance and movement
const int SPIDER_RADIUS = 25;
const int SPIDER_SPEED  = 3;

// Fly appearance
const int FLY_RADIUS = 10;

int main()
{
    // Open the game window
    open_window("Fly Catch", SCREEN_WIDTH, SCREEN_HEIGHT);

    // Create and start the timer — used to control when the fly appears
    create_timer(GAME_TIMER_NAME);
    start_timer(GAME_TIMER_NAME);

    // Spider starts at the center of the screen
    int spider_x = SCREEN_WIDTH / 2;
    int spider_y = SCREEN_HEIGHT / 2;

    // Fly position — will be randomised again when it actually appears
    int fly_x = rnd(SCREEN_WIDTH);
    int fly_y = rnd(SCREEN_HEIGHT);

    // Tracks whether the fly is currently visible on screen
    bool fly_has_appeared = false;

    // The fly will appear at a random time between 1 and 3 seconds
    long fly_appear_at_ms = 1000 + rnd(2000);

    // Main game loop — runs until the user closes the window
    while (!quit_requested())
    {
        // Move spider right, but prevent it from going off the right edge
        if (key_down(RIGHT_KEY) && spider_x + SPIDER_RADIUS < SCREEN_WIDTH)
        {
            spider_x += SPIDER_SPEED;
        }

        // Move spider left, but prevent it from going off the left edge
        if (key_down(LEFT_KEY) && spider_x - SPIDER_RADIUS > 0)
        {
            spider_x -= SPIDER_SPEED;
        }

        // Once enough time has passed, place the fly at a new random position
        if (!fly_has_appeared && timer_ticks(GAME_TIMER_NAME) > fly_appear_at_ms)
        {
            fly_has_appeared = true;
            fly_x = rnd(SCREEN_WIDTH);
            fly_y = rnd(SCREEN_HEIGHT);
        }

        // --- Drawing ---

        // Clear the previous frame with a white background
        clear_screen(color_white());

        // Draw the spider as a black circle
        fill_circle(color_black(), spider_x, spider_y, SPIDER_RADIUS);

        // Only draw the fly once it has appeared
        if (fly_has_appeared)
        {
            fill_circle(color_dark_green(), fly_x, fly_y, FLY_RADIUS);
        }

        // Render the frame at 60 frames per second
        refresh_screen(60);

        // Get any new user interactions
        process_events();
    }

    return 0;
}