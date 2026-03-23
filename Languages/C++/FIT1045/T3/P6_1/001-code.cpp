#include "splashkit.h"
#include "utilities.h"

void draw_heading_line(int length)
{
    int i = 0;
    write("+");
    while (i < length - 2)
    {
        write("-");
        i++;
    }
    write_line("+");
}

void draw_spaces(int length)
{
    int i = 0;
    while (i < length)
    {
        write(" ");
        i++;
    }
}

void draw_title(string title, int width)
{
    draw_heading_line(width);
    int num_spaces = width - length_of(title) - 3;
    write("| " + title);
    draw_spaces(num_spaces);
    write("|\n");
    draw_heading_line(width);
}


int score_calculator(int goals, int behinds)
{
    return goals * 6 + behinds;
}

void current_stat(string stat_name, int stat)
{
    write_line("\nCurrent " + stat_name + ": " + to_string(stat) + "\n");
}

int main_menu_gen()
{
    draw_title("Main Menu", 26);
    write_line("1: Update Goals");
    write_line("2: Update behinds");
    write_line("3: Print details");
    write_line("4: Quit");
    draw_heading_line(26);

    return read_integer_range("Enter Option: ", 1, 4);
}

int update_goals(int goals, int behinds)
{
    current_stat("goals", goals);
    goals = read_integer("Enter new goals: ");
    current_stat("Score", score_calculator(goals, behinds));
    return goals;
}

int update_behinds(int goals, int behinds)
{
    current_stat("behinds", behinds);
    goals = read_integer("Enter new behinds: ");
    current_stat("Score", score_calculator(goals, behinds));
    return behinds;
}

void print_details(string team, int goals, int behinds)
{
    write_line("Hawks:");
    write_line("\t" + to_string(goals) + " Goals");
    write_line("\t" + to_string(behinds) + " Behinds");
    write_line("\t" + to_string(score_calculator(goals, behinds)) + "\n\n");
}

bool end_program()
{
    string input;
    do
    {
        input = read_string("Are you sure you want to quit? [Y/N]: ");
    } while (to_lowercase(input) != "n" && to_lowercase(input) != "y");

    if (to_lowercase(input) == "n")
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main()
{
    string team;
    int goals;
    int behinds;

    draw_title("Score Calculator", 26);
    write_line("\n\nWelcome to the AFL score calculator!");

    team = read_string("Enter team name: ");
    goals = read_integer("Enter goals: ");
    behinds = read_integer("Enter behinds: ");

    current_stat("Score", score_calculator(goals, behinds));

    bool again = true;
    int option;

    do
    {
        option = main_menu_gen();
        switch (option)
        {
        case 1:
            goals = update_goals(goals, behinds);
            break;
        case 2:
            behinds = update_behinds(goals, behinds);
            break;
        case 3:
            print_details(team, goals, behinds);
            break;
        case 4:
            again = end_program();
            break;
        }

    } while (again == true);

    write_line("Bye!");
}