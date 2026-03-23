#include "splashkit.h"

int main()
{
    int counter;
    double avg, total;
    string cont, number;
    cont = "y";
    counter = 0;
    while (cont == "y")
    {
        write("Enter value: ");
        number = read_line();
        while (!is_double(number))
        {
            write_line("Error! Please try again.");
            write_line("Enter value: ");
            number = read_line(); 
        }
        total = to_double(number) + total;
        counter = counter + 1;
        avg = total / counter;
        write_line("Total: " + to_string(total));
        write_line("Average " + to_string(avg));
        write_line("Count: " + to_string(counter));
        write_line("Do you wish to continue? [y/n]");
        cont = read_line();
        if (cont == "N" || cont == "no" || cont == "n" || cont == "no" || cont == "No" || cont == "NO")
        {
            break;
        }
        else
        {
            while (cont != "y")
            {
                write_line("Error! Please try again.");
                write_line("Do you wish to continue? [y/n]");
                cont = read_line();
            }
        }
    }
    write("I hope you acquired all of the information that you need.");
}
