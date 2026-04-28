package Classwork;

import java.util.*;

// Abstract class
abstract class Vehicle {
    protected String licensePlate;
    protected int fuelCapacity;

    public Vehicle(String licensePlate, int fuelCapacity) {
        this.licensePlate = licensePlate;
        this.fuelCapacity = fuelCapacity;
    }

    // Abstract method
    public abstract int calculateRange();

    // Display method
    public void displayInfo() {
        System.out.println("Vehicle: " + this.getClass().getSimpleName() +
                " | License: " + licensePlate +
                " | Range: " + calculateRange() + " miles");
    }
}

// Truck class
class Truck extends Vehicle {
    public Truck(String licensePlate, int fuelCapacity) {
        super(licensePlate, fuelCapacity);
    }

    @Override
    public int calculateRange() {
        return fuelCapacity * 5;
    }
}

// Van class
class Van extends Vehicle {
    public Van(String licensePlate, int fuelCapacity) {
        super(licensePlate, fuelCapacity);
    }

    @Override
    public int calculateRange() {
        return fuelCapacity * 8;
    }
}

// Main class
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            System.out.print("Enter number of vehicles: ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter type (Truck/Van), license, fuel: ");
                String type = sc.next();
                String license = sc.next();
                int fuel = sc.nextInt();

                if (type.equalsIgnoreCase("Truck")) {
                    vehicles.add(new Truck(license, fuel));
                } else if (type.equalsIgnoreCase("Van")) {
                    vehicles.add(new Van(license, fuel));
                } else {
                    System.out.println("Invalid vehicle type. Skipping entry.");
                }
            }

            System.out.println("\nVehicle Details:");
            for (Vehicle v : vehicles) {
                v.displayInfo();
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format.");
        } finally {
            sc.close();
        }
    }
}