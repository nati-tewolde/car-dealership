package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {

    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 99) {
            System.out.println("\nWelcome to the Car Dealership!");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your selection: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection, please enter a valid selection.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("\nExiting application ...");
                default -> System.out.println("\nInvalid selection.");
            }
        }
        scanner.close();
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    private void init() {
        DealershipFileManager dealershipDetails = new DealershipFileManager();
        this.dealership =  dealershipDetails.getDealership();
    }

    private void displayVehicles(List<Vehicle> inventory) {
        System.out.printf("%n%55s%n%n", "--Vehicle Inventory--");
        System.out.printf("%-6s | %-4s | %-12s | %-8s | %-8s | %-8s | %-8s | %9s%n",
                "VIN", "Year", "Make", "Model", "Vehicle Type", "Color", "Mileage", "Price");
        System.out.println("-".repeat(88));

        for (Vehicle vehicle : inventory) {
            System.out.printf("%-6s | %-4s | %-12s | %-8s | %-12s | %-8s | %-8s | %9s%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    String.format("$%.2f", vehicle.getPrice()));
        }

    }

}
