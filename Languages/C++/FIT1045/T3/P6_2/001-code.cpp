#include "splashkit.h"
#include "utilities.h"

int scoring(int goals, int behinds)
{
    int play_total;
    play_total = 0;
    play_total = goals * 6;
    play_total += behinds;
    write_line(to_string(play_total) + " points scored this play.");
    return play_total;
}

void print_score(int goals, int behinds, int score, string name)
{
    write_line(name);
    write_line(to_string(behinds) + " Behinds");
    write_line(to_string(goals) + " Goals");
    write_line(to_string(score) + " Total");
    write(to_string(goals) + "." + to_string(behinds));
    write("." + to_string(score));
    write_line("\nBye - enjoy the rest of your day!");
}

int main()
{
    string again = "";
    string input, team_name, print;
    int goals, behinds, score, play, total_goals, total_behinds;
    score = 0;
    total_goals = 0;
    total_behinds = 0;
    print_repeated("+", 1, false);
    print_repeated("-", 24, false);
    print_repeated("+", 1, false);
    write("\n");
    write("Welcome to the AFL score calculator!");
    write("\n");
    print_repeated("+", 1, false);
    print_repeated("-", 24, false);
    print_repeated("+", 1, true);
    write("Enter team name: ");
    team_name = read_line();
    do
    {
        goals = read_integer("Enter goals from this play: ");
        total_goals += goals;
        behinds = read_integer("Enter Behinds from this play: ");
        total_behinds += behinds;
        play = scoring(goals, behinds);
        score = score + play;
        write_line("Current score: " + to_string(score));
        again = read_string("Do you want to add another score [Y/n]? ");

    } while (again != "N" && again != "n");

    write_line("Would you like to print scores? ");
    print = read_line();
    if (print == "N" || print == "n" || print == "no" || print == "NO" || print == "No" || print == "nO")
    {
        write_line("\nBye - enjoy the rest of your day!");
        return 0;
    }
    else
    {
        print_score(total_goals, total_behinds, score, team_name);
    }
}