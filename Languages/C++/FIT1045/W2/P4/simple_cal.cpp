#include "splashkit.h"

int main()
{
    const double MINUTES_PER_HOUR = 60.0;

    string name;
    string user_input;

    double distance_travelled;
    double time_taken_minutes;
    double average_speed;
    double distance_remaining;
    double time_remaining_minutes;
    double total_distance;
    double total_time_minutes;

    write("What is your name: ");
    name = read_line();

    write_line();
    write_line("Hi " + name + ".");

    write_line();
    write("How far have you travelled so far? Enter km: ");
    user_input = read_line();
    distance_travelled = to_double(user_input);

    write("How long has it taken? Enter minutes: ");
    user_input = read_line();
    time_taken_minutes = to_double(user_input);

    average_speed = distance_travelled / (time_taken_minutes / MINUTES_PER_HOUR);

    write_line();
    write_line("Your average speed is " + to_string(average_speed) + " km/h");

    write_line();
    write("How far do you have to go? Enter km: ");
    user_input = read_line();
    distance_remaining = to_double(user_input);

    time_remaining_minutes = (distance_remaining / average_speed) * MINUTES_PER_HOUR;
    total_distance = distance_travelled + distance_remaining;
    total_time_minutes = time_taken_minutes + time_remaining_minutes;

    write_line();
    write_line("You will take another " + to_string(time_remaining_minutes,1) + " minutes before you arrive");
    write_line("Total distance will be " + to_string(total_distance,1) + " km");
    write_line("Total time will be " + to_string(total_time_minutes,1) + " minutes");

    return 0;
}