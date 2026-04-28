package Classwork;
import java.util.*;

abstract class Vehicle1 {
    protected String licensePlate;
    protected int fuelCapacity;

    public Vehicle1(String licensePlate, int fuelCapacity) {
        this.licensePlate = licensePlate;
        this.fuelCapacity = fuelCapacity;
    }

    public abstract int calculateRange();

    public void displayInfo(String type) {
        System.out.println("Vehicle1: " + type + " | License: " + licensePlate +
                " | Range: " + calculateRange() + " miles");
    }
}

class Truck1 extends Vehicle1 {
    public Truck1(String licensePlate, int fuelCapacity) {
        super(licensePlate, fuelCapacity);
    }

    public int calculateRange() {
        return fuelCapacity * 5;
    }
}

class Van1 extends Vehicle1 {
    public Van1(String licensePlate, int fuelCapacity) {
        super(licensePlate, fuelCapacity);
    }

    public int calculateRange() {
        return fuelCapacity * 8;
    }
}

public class  tester{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next();
        String license = sc.next();
        int fuel = sc.nextInt();

        Vehicle1 Vehicle1;

        if (type.equalsIgnoreCase("Truck1")) {
            Vehicle1 = new Truck1(license, fuel);
            Vehicle1.displayInfo("Truck1");
        } else if (type.equalsIgnoreCase("Van1")) {
            Vehicle1 = new Van1(license, fuel);
            Vehicle1.displayInfo("Van1");
        } else {
            System.out.println("Invalid Vehicle1 type");
        }

        sc.close();
    }
}