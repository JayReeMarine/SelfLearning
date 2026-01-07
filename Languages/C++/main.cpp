#include "splashkit.h"
#include "utilities.h"

int main()
{
    string name = read_string("Enter name: ");
    int score = read_integer("Enter score: ");

    write_line(name);
    write_line(score);

    return 0;
}
