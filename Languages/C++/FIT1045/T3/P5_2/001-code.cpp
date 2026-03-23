#include "splashkit.h"

int main()
{
    string line;
    int count = 0;
    double value;
    bool anothervalue = false; 
    double total = 0;
    double average;


    write_line("Welcome to the simple stats calculator!");
    write("Enter value: ");
    line = read_line();

    do
    {
        while (not is_double(line))
        {
            write_line("Please enter a real number");
            write("Enter your choice: ");
            line = read_line();
        }

    value = to_double(line);
    total = total + value;
    count = count + 1;
    average = (total) / (count);
    
    write_line("Total: " + to_string(total));
    write_line("Count: " + to_string(count));
    write_line("Average: " + to_string(average));

    write("Would you like to add another value[y/n]?: ");
    line = read_line();
    anothervalue = (to_lowercase(line) == "yes") or (to_lowercase(line) == "y");


        } while (anothervalue != false);

       write_line("Goodbye, I hope i helped!");
}