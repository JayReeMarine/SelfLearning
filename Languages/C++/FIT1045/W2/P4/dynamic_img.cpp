#include "splashkit.h"

const string IMAGE_NAME = "tree";

int main()
{
    string user_input;
    double rotation;
    bitmap tree;

    write("Enter rotation degrees: ");
    user_input = read_line();
    rotation = to_double(user_input);

    open_window("Image Drawing", 1000, 600);

    tree = load_bitmap(IMAGE_NAME, "tree.png");

    draw_bitmap(tree, 10, 20);
    draw_bitmap(IMAGE_NAME, 220, 50, option_rotate_bmp(rotation));
    refresh_screen();
    delay(5000);

    return 0;
}