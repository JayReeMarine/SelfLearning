#include "splashkit.h"

/**
 * Read a string from the user
 *
 * @param prompt the message to show the user
 * @returns the string entered
 */
string read_string(string prompt)
{
    write(prompt);
    return read_line();
}

/**
 * Read an integer from the user
 *
 * @param prompt the message to show the user
 * @returns the integer entered
 */
int read_integer(string prompt)
{
    string line = read_string(prompt);
    return convert_to_integer(line);
}
