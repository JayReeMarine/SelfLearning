#include "splashkit.h"

// ============================================================
// read_integer
// ------------
// Displays a prompt and reads a validated integer.
// Keeps asking until the user enters a valid whole number.
// ============================================================
int read_integer(string prompt)
{
    string input;

    while (true)
    {
        write(prompt);
        input = read_line();

        // Check every character is a digit (allow leading '-')
        bool is_valid = !input.empty();
        for (int i = 0; i < input.length(); i++)
        {
            if (i == 0 && input[i] == '-')
            {
                continue;
            }
            if (!isdigit(input[i]))
            {
                is_valid = false;
                break;
            }
        }

        if (is_valid)
        {
            return stoi(input);
        }

        write_line("Please enter a whole number");
    }
}

// ============================================================
// read_integer_range
// ------------------
// Reads an integer and ensures it falls within [min, max].
// Keeps asking until a valid in-range value is entered.
// ============================================================
int read_integer_range(string prompt, int min, int max)
{
    int value;

    while (true)
    {
        value = read_integer(prompt);

        if (value >= min && value <= max)
        {
            return value;
        }

        write_line("Please enter a number between " + to_string(min) + " and " + to_string(max));
    }
}

// ============================================================
// read_string
// -----------
// Displays a prompt and reads a line of text from the user.
// ============================================================
string read_string(string prompt)
{
    write(prompt);
    return read_line();
}

// ============================================================
// draw_heading_line
// -----------------
// Outputs a border line like: +------------------------+
// 'width' controls how many '-' characters appear inside.
// ============================================================
void draw_heading_line(int width)
{
    write("+");
    for (int i = 0; i < width; i++)
    {
        write("-");
    }
    write_line("+");
}

// ============================================================
// draw_title
// ----------
// Outputs a title inside a box using draw_heading_line.
// Example (title="Main Menu", width=26):
//   +------------------------+
//   | Main Menu              |
//   +------------------------+
//
// The title is left-aligned, padded with spaces to fill width.
// ============================================================
void draw_title(string title, int width)
{
    // Top border
    draw_heading_line(width);

    // Title line: "| Title         |"
    // Calculate how many spaces needed after the title
    int text_area    = width - 2;          // subtract the two spaces around title
    int title_length = title.length();
    int padding      = text_area - title_length;

    write("| " + title);

    // Fill the remaining space with spaces before the closing |
    for (int i = 0; i < padding; i++)
    {
        write(" ");
    }
    write_line(" |");

    // Bottom border
    draw_heading_line(width);
}

// ============================================================
// calculate_score
// ---------------
// Returns the AFL score for a team.
// Formula: (goals * 6) + (behinds * 1)
// ============================================================
int calculate_score(int goals, int behinds)
{
    return (goals * 6) + behinds;
}

// ============================================================
// print_team_details
// ------------------
// Outputs the team's name, goals, behinds, and total score.
// Example:
//   Hawks:
//     5 Goals
//     13 Behinds
//     43
// ============================================================
void print_team_details(string name, int goals, int behinds)
{
    int score = calculate_score(goals, behinds);

    write_line(name + ":");
    write_line("    " + to_string(goals)   + " Goals");
    write_line("    " + to_string(behinds) + " Behinds");
    write_line("    " + to_string(score));
}

// ============================================================
// print_menu
// ----------
// Outputs the main menu options inside a titled box.
// ============================================================
void print_menu(int width)
{
    draw_title("Main Menu", width);
    write_line("1: Update goals");
    write_line("2: Update behinds");
    write_line("3: Print details");
    write_line("4: Quit");
    draw_heading_line(width);
}

// ============================================================
// main
// ----
// Entry point. Reads initial team data, then runs a menu loop
// allowing the user to update and view the team's score.
// ============================================================
int main()
{
    const int MENU_WIDTH    = 26;
    const int MENU_MIN      = 1;
    const int MENU_MAX      = 4;

    // --- Welcome screen ---
    draw_title("Score Calculator", MENU_WIDTH);
    write_line("Welcome to the AFL score calculator!");
    write_line("");

    // --- Read initial team data ---
    string team_name = read_string("Enter team name: ");
    int    goals     = read_integer("Enter goals: ");
    int    behinds   = read_integer("Enter behinds: ");

    // --- Show initial score ---
    write_line("");
    write_line("Current Score: " + to_string(calculate_score(goals, behinds)));
    write_line("");

    // --- Menu loop ---
    int option = 0;

    while (option != 4)
    {
        print_menu(MENU_WIDTH);

        option = read_integer_range("Enter Option: ", MENU_MIN, MENU_MAX);
        write_line("");

        if (option == 1)
        {
            // Update goals
            write_line("Current goals: " + to_string(goals));
            goals = read_integer("Enter new goals: ");
            write_line("");
            write_line("Current Score: " + to_string(calculate_score(goals, behinds)));
        }
        else if (option == 2)
        {
            // Update behinds
            write_line("Current behinds: " + to_string(behinds));
            behinds = read_integer("Enter new behinds: ");
            write_line("");
            write_line("Current Score: " + to_string(calculate_score(goals, behinds)));
        }
        else if (option == 3)
        {
            // Print full team details
            print_team_details(team_name, goals, behinds);
        }
        else if (option == 4)
        {
            // Quit — loop condition will exit
            write_line("Goodbye!");
        }

        write_line("");
    }

    return 0;
}