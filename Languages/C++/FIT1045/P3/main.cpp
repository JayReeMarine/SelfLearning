#include "splashkit.h"

int main()
{
    open_window("Creative Drawing- Jess", 800, 600);
    clear_screen(COLOR_WHITE);
    
    // flower centre
    fill_circle(COLOR_YELLOW, 400, 300, 40);
    
    // petal
    fill_circle(COLOR_PINK, 400, 230, 40);
    fill_circle(COLOR_PINK, 470, 300, 40);
    fill_circle(COLOR_PINK, 330, 300, 40);
    fill_circle(COLOR_PINK, 400, 370, 40);
    
    // stem
    fill_rectangle(COLOR_GREEN, 395, 340, 10, 120);

    refresh_screen (60);
    delay(5000);
    return 0;
}