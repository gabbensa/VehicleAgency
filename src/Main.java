import java.util.ArrayList;
import java.util.Scanner;

import Vehicle.Vehicle;
import Classes.Jeep;
import Classes.Frigate;
import Classes.GameGlider;
import Classes.SpyGlider;
import Classes.Amphibious;
import Classes.Bicycle;
import Classes.Cruise;




public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean stop = false;
        String car;
        ArrayList<Vehicle> vehicles = new ArrayList<>(); //creating an arraylist to save all the vehicle of the car agency
        System.out.println("Welcome to Gabriel's Vehicle Agency. ");
        while (stop != true) {
            System.out.println("\nDo you want to add a new car to the agency? (Y/N)");
            car = sc.next();
            if (car.equals("y"))
            {
                int type=0 ;
                while(type<1 ||type>7)
                {
                    System.out.println("What type of vehicle you want to add? (Select 1-7)"); // select which type of vehicle to add
                    System.out.println("1. Jeep");
                    System.out.println("2. Frigate");
                    System.out.println("3. SpyGlider");
                    System.out.println("4. GameGlider");
                    System.out.println("5. Amphibious Car");
                    System.out.println("6. Bicycle");
                    System.out.println("7. Cruise");
                    type=sc.nextInt();
                }

                // ask the user to enter parameters
                if (type == 1) {
                    System.out.println("Enter the Jeep model:");
                    sc.nextLine();
                    String model = sc.nextLine();

                    System.out.println("Enter Max speed:");
                    int maxSpeed = sc.nextInt();

                    System.out.println("Enter the average fuel consumption:");
                    double fuelConsumption = sc.nextDouble();

                    System.out.println("Enter the average engine life:");
                    double engineLife = sc.nextInt();
                    //add the vehicle to the arraylist
                    Jeep jeep = new Jeep(model, fuelConsumption, maxSpeed, engineLife);
                    vehicles.add(jeep);
                    System.out.println("Jeep added successfully.");
                }
                // ask the user to enter parameters
                if (type == 2) {
                    System.out.println("Enter the Frigate model:");
                    sc.nextLine();
                    String model = sc.nextLine();

                    System.out.println("Enter Max passengers:");
                    int maxPassengers = sc.nextInt();

                    System.out.println("Enter Max speed:");
                    int maxSpeed = sc.nextInt();

                    System.out.println("Is the frigate sailing with the wind: (y/n)");
                    String wind = sc.next();
                    while (!(wind.equals("y")) && !(wind.equals("n"))) {
                        System.out.println("Wrong input. Is the frigate sailing with the wind: (y/n): ");
                        wind = sc.next();
                    }
                    boolean windSailing;
                    if (wind.equals("y")) windSailing = true;
                    else windSailing = false;
                    //add the vehicle to the arraylist
                    Frigate frigate = new Frigate(model, maxPassengers, maxSpeed, windSailing);
                    vehicles.add(frigate);
                    System.out.println("Frigate added successfully.");
                }
                // ask the user to enter parameters
                if (type == 3) {
                    System.out.println("Enter Power source of the SpyGlider: ");
                    sc.nextLine();
                    String powerSource = sc.nextLine();
                    //add the vehicle to the arraylist
                    SpyGlider spyGlider = new SpyGlider(powerSource);
                    vehicles.add(spyGlider);
                    System.out.println("SpyGlider added successfully.");
                }
                //add the vehicle to the arraylist
                if (type == 4) {
                    System.out.println("GameGlider added successfully.");
                    GameGlider gameGlider = new GameGlider();
                    vehicles.add(gameGlider);

                }
                if(type==5)
                {
                    System.out.println("Enter the Amphibious model:");
                    sc.nextLine();
                    String model = sc.nextLine();

                    System.out.println("Enter Max passengers:");
                    int maxPassengers = sc.nextInt();

                    System.out.println("Enter Max speed:");
                    int maxSpeed = sc.nextInt();

                    System.out.println("Is the frigate sailing with the wind: (y/n)");
                    String wind = sc.next();
                    while (!(wind.equals("y")) && !(wind.equals("n"))) {
                        System.out.println("Wrong input. Is the frigate sailing with the wind: (y/n): ");
                        wind = sc.next();
                    }
                    boolean windSailing;
                    if (wind.equals("y")) windSailing = true;
                    else windSailing = false;

                    System.out.println("Enter the average fuel consumption:");
                    double fuelConsumption = sc.nextDouble();

                    System.out.println("Enter the average engine life:");
                    double engineLife = sc.nextInt();

                    Amphibious amphibious=new Amphibious(model,maxPassengers,maxSpeed,windSailing,fuelConsumption,engineLife);
                    vehicles.add(amphibious);
                }
                if(type==6)
                {
                    System.out.println("Enter the Bicycle model:");
                    sc.nextLine();
                    String model = sc.nextLine();

                    System.out.println("Enter Max speed:");
                    int maxSpeed = sc.nextInt();

                    System.out.println("Enter road type: ");
                    sc.nextLine();
                    String road=sc.nextLine();

                    Bicycle bicycle=new Bicycle(model,maxSpeed,road);
                    vehicles.add(bicycle);
                }
                if(type==7)
                {
                    System.out.println("Enter the Cruise model:");
                    sc.nextLine();
                    String model = sc.nextLine();

                    System.out.println("Enter max passengers: ");
                    int passengers= sc.nextInt();

                    System.out.println("Enter Max speed:");
                    int maxSpeed = sc.nextInt();

                    System.out.println("Enter the average fuel consumption:");
                    double fuelConsumption = sc.nextDouble();

                    System.out.println("Enter the average engine life:");
                    double engineLife = sc.nextInt();

                    Cruise cruise=new Cruise(model,passengers,maxSpeed,fuelConsumption,engineLife);
                    vehicles.add(cruise);
                }
            } else if (car.equals("n")) {
                stop = true;
            }
            else
                System.out.println("\nWrong input!");
        }
            //MENU of the car agency
            int choice = 0;
            System.out.println("Car Agency Menu:  ");
            while (choice != 5) {
                System.out.println("\nPlease choose an option: ");
                System.out.println("1. Buy a new vehicle");
                System.out.println("2. Test a vehicle");
                System.out.println("3. Reset all vehicles distance");
                System.out.println("4. Change flag of all frigates");
                System.out.println("5. Exit");
                System.out.println("\nYour choice: ");
                choice = sc.nextInt();

                boolean inStock=false;
                int index=-1;
                switch (choice)
                {
                    case 1:
                    {
                        if(vehicles.size()==0)  // if no vehicles in the array
                        {
                            System.out.println("\nSorry, no more vehicles available.");
                            break;
                        }
                        else
                        {
                            System.out.println("List of vehicles available: "); // prints all the vehicle available
                            for (int i = 0; i < vehicles.size(); i++)
                                System.out.println(vehicles.get(i).toString());
                            int buychoice = 0;
                            while (buychoice < 1 || buychoice > 7)
                            {
                                System.out.println("\nWhich vehicle do you want to buy? \n\nJeep (Press 1) , Frigate (Press 2), SpyGlider (Press 3), GameGlider (Press 4), AmphibiousCar (Press 5), Bicycle (Press 6), Cruise (Press 7)");
                                buychoice = sc.nextInt();
                                if (buychoice < 1 || buychoice > 7)
                                    System.out.println("\nWrong input!\n");
                            }
                            switch (buychoice) {   // ask to enter parameters of the vehicle you want to buy to check if it's in stock
                                case 1: {
                                    System.out.println("Enter the parameters of the Jeep you want: \nModel name: ");
                                    sc.nextLine();
                                    String model = sc.nextLine();
                                    System.out.println("Fuel consumption: ");
                                    double fuel = sc.nextDouble();
                                    System.out.println("Max speed: ");
                                    int maxSpeed = sc.nextInt();
                                    System.out.println("Engine lifetime: ");
                                    double engine = sc.nextDouble();
                                    Jeep buyJeep = new Jeep(model, fuel, maxSpeed, engine);
                                    for (int i = 0; i < vehicles.size(); i++) {
                                        if (vehicles.get(i).equals(buyJeep)) {
                                            inStock = true;
                                            index = i;
                                        }
                                    }
                                    if (inStock) {
                                        vehicles.remove(index);
                                        System.out.println("Thank you for purchasing this vehicle!");
                                    } else System.out.println("This vehicle doesn't exist. ");
                                    break;
                                }

                                case 2: {
                                    System.out.println("Enter the parameters of the Frigate you want: \nModel name: ");
                                    sc.nextLine();
                                    String model = sc.nextLine();
                                    System.out.println("Max passengers: ");
                                    int passengers = sc.nextInt();
                                    System.out.println("Max speed: ");
                                    int maxSpeed = sc.nextInt();
                                    System.out.println("Is the frigate sailing with the wind: (y/n)");
                                    String wind = sc.next();
                                    while (!(wind.equals("y")) && !(wind.equals("n"))) {
                                        System.out.println("Wrong input. Is the frigate sailing with the wind: (y/n): ");
                                        wind = sc.next();
                                    }
                                    boolean windSailing;
                                    if (wind.equals("y")) windSailing = true;
                                    else windSailing = false;
                                    Frigate buyFrigate = new Frigate(model, passengers, maxSpeed, windSailing);
                                    for (int i = 0; i < vehicles.size(); i++) {
                                        if (vehicles.get(i).equals(buyFrigate)) {
                                            inStock = true;
                                            index = i;
                                        }
                                    }
                                    if (inStock) {
                                        vehicles.remove(index);
                                        System.out.println("Thank you for purchasing this vehicle!");
                                    } else System.out.println("This vehicle doesn't exist. ");
                                    break;
                                }


                                case 3: {
                                    System.out.println("Enter the parameters of the SpyGlider you want: \n\nPower source: ");
                                    sc.nextLine();
                                    String power = sc.nextLine();
                                    SpyGlider buySpy = new SpyGlider(power);
                                    for (int i = 0; i < vehicles.size(); i++) {
                                        if (vehicles.get(i).equals(buySpy)) {
                                            inStock = true;
                                            index = i;
                                        }
                                    }
                                    if (inStock) {
                                        vehicles.remove(index);
                                        System.out.println("Thank you for purchasing this vehicle!");
                                    } else System.out.println("This vehicle doesn't exist. ");
                                    break;
                                }

                                case 4: {
                                    GameGlider buyGame = new GameGlider();
                                    for (int i = 0; i < vehicles.size(); i++) {
                                        if (vehicles.get(i).equals(buyGame)) {
                                            inStock = true;
                                            index = i;
                                        }
                                    }
                                    if (inStock) {
                                        vehicles.remove(index);
                                        System.out.println("Thank you for purchasing this vehicle!");
                                    } else System.out.println("This vehicle doesn't exist. ");
                                    break;
                                }
                                case 5:
                                {
                                    System.out.println("Enter the parameters of the Amphibious Car you want: \nModel name: ");
                                    sc.nextLine();
                                    String model = sc.nextLine();
                                    System.out.println("Fuel consumption: ");
                                    double fuel = sc.nextDouble();
                                    System.out.println("Max speed: ");
                                    int maxSpeed = sc.nextInt();
                                    System.out.println("Max passengers: ");
                                    int maxPassengers= sc.nextInt();
                                    System.out.println("Engine lifetime: ");
                                    double engine = sc.nextDouble();
                                    System.out.println("Is the Amphibious sailing with the wind: (y/n)");
                                    String wind = sc.next();
                                    while (!(wind.equals("y")) && !(wind.equals("n"))) {
                                        System.out.println("Wrong input. Is the frigate sailing with the wind: (y/n): ");
                                        wind = sc.next();
                                    }
                                    boolean windSailing;
                                    if (wind.equals("y")) windSailing = true;
                                    else windSailing = false;
                                    Amphibious buyAmphibious = new Amphibious(model,maxPassengers, maxSpeed,windSailing,fuel,engine);
                                    for (int i = 0; i < vehicles.size(); i++) {
                                        if (vehicles.get(i).equals(buyAmphibious)) {
                                            inStock = true;
                                            index = i;
                                        }
                                    }
                                    if (inStock) {
                                        vehicles.remove(index);
                                        System.out.println("Thank you for purchasing this vehicle!");
                                    } else System.out.println("This vehicle doesn't exist. ");
                                    break;
                                }
                                case 6:
                                {
                                    System.out.println("Enter the parameters of the Bicycle you want: \nModel name: ");
                                    sc.nextLine();
                                    String model = sc.nextLine();
                                    System.out.println("Max speed: ");
                                    int maxSpeed = sc.nextInt();
                                    System.out.println("Enter road type: ");
                                    sc.nextLine();
                                    String road=sc.nextLine();

                                    Bicycle buyBicycle=new Bicycle(model,maxSpeed,road);
                                    for (int i = 0; i < vehicles.size(); i++) {
                                        if (vehicles.get(i).equals(buyBicycle)) {
                                            inStock = true;
                                            index = i;
                                        }
                                    }
                                    if (inStock) {
                                        vehicles.remove(index);
                                        System.out.println("Thank you for purchasing this vehicle!");
                                    } else System.out.println("This vehicle doesn't exist. ");
                                    break;
                                }
                                case 7:
                                {
                                    System.out.println("Enter the parameters of the Cruise you want: \nModel name: ");
                                    sc.nextLine();
                                    String model = sc.nextLine();
                                    System.out.println("Max passengers: ");
                                    int passengers = sc.nextInt();
                                    System.out.println("Max speed: ");
                                    int maxSpeed = sc.nextInt();
                                    System.out.println("Fuel consumption: ");
                                    double fuel = sc.nextDouble();
                                    System.out.println("Engine lifetime: ");
                                    double engine = sc.nextDouble();
                                    Cruise buyCruise = new Cruise(model,passengers,maxSpeed,fuel,engine);
                                    for (int i = 0; i < vehicles.size(); i++) {
                                        if (vehicles.get(i).equals(buyCruise)) {
                                            inStock = true;
                                            index = i;
                                        }
                                    }
                                    if (inStock) {
                                        vehicles.remove(index);
                                        System.out.println("Thank you for purchasing this vehicle!");
                                    } else System.out.println("This vehicle doesn't exist. ");
                                    break;
                                }
                                default: {
                                    System.out.println("\n Wrong input! Please choose one vehicle from the list: \n\nJeep (Press 1) , Frigate (Press 2), SpyGlider (Press 3), GameGlider (Press 4), AmphibiousCar (Press 5), Bicycle (Press 6), Cruise (Press 7)");
                                    buychoice = sc.nextInt();
                                }
                            }
                        }
                            break;
                    }

                    case 2:
                    { //print all vehicles available to test
                        System.out.println("\nPlease enter the number of the vehicle you want to test: \n");
                        for(int i=0;i<vehicles.size();i++)
                            System.out.println((i+1)+"."+vehicles.get(i).toString());
                        int test= sc.nextInt();
                        if(test>(vehicles.size()+1))
                            System.out.println("Sorry, no such vehicle in the agency.");
                        else
                        { // ask the distance to travel and add it to the "distance" parameter of the vehicle
                            System.out.println("\nInsert distance: ");
                            int distance=sc.nextInt();
                            System.out.println("\nYou choose to test:");
                            System.out.println(vehicles.get(test-1).toString());
                            vehicles.get(test-1).Travel(distance);
                            System.out.println("\nThe vehicle has been successfully tested.");
                        }
                        break;
                    }
                    case 3: // allow to reset all the distances of all the vehicles
                    {
                        for(int i=0;i<vehicles.size();i++)
                            vehicles.get(i).Travel(0);
                        System.out.println("\nAll distances have been reset.");
                        break;
                    }
                    case 4: // allow to change the flag of all the Frigates in the arraylist
                    {
                        boolean done = false;
                        System.out.println("Enter the new flag: ");
                        sc.nextLine();
                        String newFlag = sc.nextLine();

                        for(int i = 0; i < vehicles.size(); i++) {
                            if(vehicles.get(i) instanceof Frigate) {
                                ((Frigate)vehicles.get(i)).setCountryFlag(newFlag);
                                done = true;
                            }
                        }
                        for(int i = 0; i < vehicles.size(); i++) {
                            if(vehicles.get(i) instanceof Cruise) {
                                ((Cruise)vehicles.get(i)).setCountryFlag(newFlag);
                                done = true;
                            }
                        }
                        for(int i = 0; i < vehicles.size(); i++) {
                            if(vehicles.get(i) instanceof Amphibious) {
                                ((Amphibious)vehicles.get(i)).setCountryFlag(newFlag);
                                done = true;
                            }
                        }

                        if(done) {
                            System.out.println("\nThe flags have been changed.");
                        }
                        else System.out.println("There is no Frigate in the agency.");
                        break;
                    }
                    case 5: // exit the program
                    {
                        sc.close();
                        System.out.println("\nThank you ! Have a nice day.");
                        break;
                    }
                }
            }
        }
    }




