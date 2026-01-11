#include "splashkit.h"
#include <string>

using std::string;

// Struct: Car groups data that belongs together
struct Car
{
    string plate;            // identifier / name of the car
    string model;            // model name
    double fuel_litres;      // current fuel (stored as double for calculations)
    double fuel_capacity;    // maximum fuel
    double odometer_km;      // total distance travelled
};

// Helper function: convert a double to an int for clean display (no decimals)
int as_int(double value)
{
    return (int)value; // simple truncation: 12.9 -> 12
}

// Function: creates and returns a new Car (returns a value)
Car create_car(const string &plate, const string &model, double capacity_litres)
{
    Car c;
    c.plate = plate;
    c.model = model;
    c.fuel_capacity = capacity_litres;
    c.fuel_litres = capacity_litres; // start full
    c.odometer_km = 0.0;             // start at 0 km
    return c;
}

// Function: calculate how much fuel is needed to drive a distance
double fuel_needed_litres(double distance_km, double km_per_litre)
{
    return distance_km / km_per_litre;
}

// Function: returns estimated remaining range in kilometres (rounded down to int)
int range_km(const Car &car, double km_per_litre)
{
    return as_int(car.fuel_litres * km_per_litre);
}

// Procedure: prints a snapshot of the car state (no return value)
void print_car(const Car &car)
{
    write_line("Plate: " + car.plate);
    write_line("Model: " + car.model);
    // We store fuel as double for accurate maths, but display as int for readability
    write_line("Fuel: " + std::to_string(as_int(car.fuel_litres)) +
               " / " + std::to_string(as_int(car.fuel_capacity)) + " L");
    write_line("Odometer: " + std::to_string(as_int(car.odometer_km)) + " km");
}

// Procedure: drives the car if enough fuel, updating the original Car (pass by reference)
void drive(Car &car, double distance_km, double km_per_litre)
{
    // Compute fuel needed for this trip
    double needed = fuel_needed_litres(distance_km, km_per_litre);

    // Compare required fuel with current fuel
    if (needed <= car.fuel_litres)
    {
        // Update state (this changes the original car because of &)
        car.fuel_litres -= needed;
        car.odometer_km += distance_km;
        write_line("Drive successful: " + std::to_string(as_int(distance_km)) + " km");
    }
    else
    {
        // Not enough fuel: car state remains unchanged
        write_line("Not enough fuel to drive " + std::to_string(as_int(distance_km)) + " km");
    }
}

int main()
{
    // Constant: how fuel efficient the car is
    const double KM_PER_LITRE = 12.0;

    // Create a car using a function that returns a Car struct
    Car my_car = create_car("Jae's Car", "Mazda", 40.0);

    // Print initial state
    write_line("=== Initial Car State ===");
    print_car(my_car);
    write_line("Estimated range: " + std::to_string(range_km(my_car, KM_PER_LITRE)) + " km");

    // Drive the car
    write_line("---");
    drive(my_car, 120.0, KM_PER_LITRE);

    // Print updated state
    write_line("---");
    write_line("=== After Driving ===");
    print_car(my_car);
    write_line("Estimated range: " + std::to_string(range_km(my_car, KM_PER_LITRE)) + " km");
    return 0;
}
