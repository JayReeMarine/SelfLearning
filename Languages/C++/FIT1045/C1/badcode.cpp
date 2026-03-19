#include <splashkit.h>

string GAME_TIMER = "GameTimer";

int SW = 800;
int SH = 600;
int SR = 25;
int SS = 3;

int FR = 3;

// Set the spider in the center of the screen
int X = SW / 2;int Y = SH / 2;

int main(){



int fX = rnd(800), fY = rnd(600);
bool flyAppeared = false;
long appearAtTime = 1000 + rnd(2000);
open_window("Fly Catch", SW, SH);

create_timer(GAME_TIMER);
start_timer(GAME_TIMER);

while (!quit_requested())
{
    if (key_down(RIGHT_KEY) && X + SR < SW){ X += SS;}

    if (key_down(LEFT_KEY) && X - SR > 0)
    {X -= SS;}
 if (!flyAppeared && timer_ticks(GAME_TIMER) > appearAtTime)
    {
        flyAppeared = true;

        fX = rnd(SW);fY = rnd(SH);
    }


clear_screen(color_white());
fill_circle(color_black(), X, Y, SR);

    // Update the Game
    // Check if the fly should appear
   
    if (flyAppeared)
    {
        fill_circle(color_dark_green(), fX, fY, FR);
    }

    refresh_screen(60);process_events();
}
}