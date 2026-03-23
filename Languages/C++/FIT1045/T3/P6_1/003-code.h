#ifndef UTILITIES_H
#define UTILITIES_H

#include <string>
using std::string;

string read_string(string prompt);
int read_integer(string prompt);
double read_double(string prompt);
int read_integer_range(string prompt, int low, int high);


#endif