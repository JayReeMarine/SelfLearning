#include "utilities.h"
#include "splashkit.h"

string read_string(string prompt)
{
  write(prompt);
  return read_line();
}

int read_integer(string prompt)
{
  string line = read_string(prompt);
  while (!is_integer(line))
  {
    write_line("Please enter a whole number.");
    line = read_string(prompt);
  }
  return to_integer(line);
}

double read_double(string prompt){
  string line = read_string(prompt);
  while (!is_double(line)){
    write_line("Please enter a double.");
    line = read_string(prompt);
  }
  return to_double(line);
}

int read_integer_range(string prompt, int low, int high)
{
    int input = read_integer(prompt);
    while (input < low || input > high)
    {
        write_line("Please enter a value between " + to_string(low) + " " + to_string(high));
        input = read_integer(prompt);
    }
    return input;
}