#include "utilities.h"
#include "splashkit.h"
/**
 *
 * @param text
 * @param times
 * @param with_newline
 */
void print_repeated(string text, int times, bool with_newline)
{
    int i = 0;
    while (i < times)
    {
        write(text);
        i++;
    }
    if (with_newline)
    {
        write_line("\n");
    }
}

/**
 * @param length
 */
void print_line(int length)
{
    print_repeated("-", length, true);
}

/**
 * @param goals
 * @param behinds
 */
string read_string(string prompt)
{
    write(prompt);
    return read_line();
}

int read_integer(string prompt)
{
    string input = read_string(prompt);

    while (!is_integer(input))
    {
        write_line("Whole numbers only.");
        input = read_string(prompt);
    }

    return to_integer(input);
}

/**
 * @returns
 */