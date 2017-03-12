package ticketreservationsystem;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class does the object creation and does method calls. It is in short the
 * main engine and is the binder UI of Logic/data.
 *
 * @version 1
 * @author asty
 */
public class Application {

    private FlightReservationSystem flightReservationSystem;
    private boolean falseValue;
    private Scanner input;

    /**
     * Starts the application
     */
    public Application() {
        flightReservationSystem = new FlightReservationSystem();
        input = new Scanner(System.in);
        falseValue = true;
    }

    /**
     * initalize the app.
     */
    public void init() {
        System.out.println("init() was called");
    }
    
    /**
     * Creates a new plane
     */

    void doCreateNewPlane() {
        String name = "";
        String description = "";
        int seatsWithinRow = 0;
        int numberOfSeatRows = 0;

        System.out.println("doCreateNewPlane() was called");
        System.out.println("You are about to create a new plane!");
        System.out.println("To create a new plane we need to ask you "
                + "4 questions");
        while (falseValue) {
            System.out.println("1. What is the name of the new plane?");
            name = input.nextLine();
            if (Pattern.matches(".*[a-z]", name)) {
                falseValue = false;
            }
        }
        falseValue = true;
        while (falseValue) {
            System.out.println("2. Please type a description of the plane");
            description = input.nextLine();
            if (Pattern.matches(".*[a-z]", name)) {
                falseValue = false;
            }
        }
        falseValue = true;
        while (falseValue) {
            System.out.println("3. How many seats within the row do you want?");
            if (input.hasNextInt()) {
                seatsWithinRow = input.nextInt();
                if (seatsWithinRow <= 16) {
                    falseValue = false;
                }
            } 
            else 
            {
                System.out.println("Please type a number!");
                input.next();
            }
        }
        falseValue = true;
        while (falseValue) {
            System.out.println("4. How many seat rows do you want?");
            if (input.hasNextInt()) {
                numberOfSeatRows = input.nextInt();
                falseValue = false;
            }

            input.nextLine();

        }
        falseValue = true;
        flightReservationSystem.doCreateNewPlane(name, description,
                seatsWithinRow, numberOfSeatRows);

    }

    /**
     * Creates a flight. Need a input about departure and planetype
     */
    void doCreateFlight() {
        int hour = 0;
        int minute = 0;
        int flightType = 0;
        System.out.println("doCreateFlight() was called");
        while (falseValue) {
            System.out.println("Please set hour of departure, 0 to 24:");
            if (input.hasNextInt()) {
                hour = input.nextInt();
                if (hour >= 0 && hour <= 24) {
                    falseValue = false;
                } 
                else 
                {
                    System.out.println("Please enter a number within 0 to 24.");
                }
            } 
            else 
            {
                System.out.println("Please enter a number within 0 to 24.");
                input.next();
            }
        }
        falseValue = true;
        while (falseValue) {
            System.out.println("Please set minute of departure, 0 to 59.");
            if (input.hasNextInt()) {
                minute = input.nextInt();
                if (minute >= 0 && minute <= 59) {
                    falseValue = false;
                } 
                else 
                {
                    System.out.println("Please enter a number within 0 to 59.");
                }
            } 
            else
            {
                System.out.println("Please enter a number within 0 to 59.");
                input.nextLine();
            }
        }
        falseValue = true;
        while (falseValue) {
            System.out.println("Please choose your prefered plane(choose by "
                    + "typing a number): ");
            System.out.println(flightReservationSystem.getListOfAllPlanes());
            if (input.hasNextInt()) {
                flightType = input.nextInt();
                if (flightType >= 1 && flightType <= flightReservationSystem.getTotalNumberOfPlanes()) {
                    falseValue = false;
                } 
                else 
                {
                    System.out.println("Please enter a number between 1 and "
                            + flightReservationSystem.getTotalNumberOfPlanes());
                }
            } 
            else 
            {    
                System.out.println("Please enter a number between 1 and "
                        + flightReservationSystem.getTotalNumberOfPlanes());
                input.next();
            }

            input.nextLine();

        }
        falseValue = true;
        flightReservationSystem.doCreateFlight(hour, minute, flightType);
        System.out.println();
        System.out.println("");
    }

    /**
     * Creates a new passenger
     */
    void doRegisterPassenger() {
        String firstName = "";
        String lastName = "";
        String eMailAddress = "";

        while (falseValue) {
            System.out.println("doRegisterPassenger() was called");
            System.out.println("\nPlease enter your firstname:");
            firstName = input.nextLine();
            if (Pattern.matches(".*[a-z]", firstName)) {
                falseValue = false;
            }
        }
        falseValue = true;
        while (falseValue) {
            System.out.println("\nPlease enter your lastname:");
            lastName = input.nextLine();
            if (Pattern.matches(".*[a-z]", lastName)) {
                falseValue = false;
            }
        }
        falseValue = true;
        while (falseValue) {
            System.out.println("\nPlease enter your email:");
            eMailAddress = input.nextLine();
            if (Pattern.matches(".*[a-z]", eMailAddress)) {
                falseValue = false;
            }
        }
        falseValue = true;
        flightReservationSystem.doRegisterPassenger(firstName, lastName, 
                eMailAddress);
    }

    /**
     * Sells a ticket. Need a input about passengers fullname and flight
     * departure.
     */
    void doSellTicket() {

        String fullName = "";
        String flightDeparture = "";
        String seatOnFlight = "";
        String answer = "";

        System.out.println("doSellTicket() was called");
        while (falseValue) {
            if (flightReservationSystem.getHashSetOfPassenger().isEmpty()) {
                System.out.println("You have not registeret "
                        + "any passengers yet");
                System.out.println("Do you want to register a passenger? "
                        + "yes/no");
                answer = input.nextLine();
                if (answer.equals("yes")) {
                    doRegisterPassenger();
                    falseValue = false;
                } 
                else if (answer.equals("no")) 
                {
                    System.out.println("Sorry, but you can't order a ticket "
                            + "when there is no passengers");
                    return;
                } 
                else 
                {
                    System.out.println("Sorry, but I did not understand that");
                }
            }
            else 
            {
                falseValue = false;
            }
        }
        falseValue = true;

        while (falseValue) {
            if (flightReservationSystem.getHashSetOfFlight().isEmpty()) {
                System.out.println("You have not created any flights yet");
                System.out.println("Do you want to create a flight? yes/no");
                answer = input.nextLine();
                if (answer.equals("yes")) {
                    doCreateFlight();
                    falseValue = false;
                } 
                else if (answer.equals("no")) 
                {
                    System.out.println("Sorry, but you can't order a ticket "
                            + "when there is no flights");
                    return;
                } 
                else 
                {
                    System.out.println("Sorry, but I did not understand that");
                }
            } 
            else 
            {
                falseValue = false;
            }
        }
        falseValue = true;

        while (falseValue) {
            System.out.println("Please select passengers by typing the "
                    + "passengers full name");
            System.out.println("Here is a list of all the currently registered "
                    + "passengers");
            System.out.println(flightReservationSystem.getListOfAllPassengers() 
                    + "\n");
            fullName = input.nextLine();
            for (Passenger passenger : flightReservationSystem.getHashSetOfPassenger()) {
                if (passenger.getFullName().equals(fullName)) {
                    falseValue = false;
                }
            }
            if (falseValue) {
                System.out.println("Please enter one of the valid passenger");
            }
        }
        falseValue = true;

        while (falseValue) {
            System.out.println("Please select flight by typing the flight "
                    + "departure");
            System.out.println("Here is a list of all the currently created "
                    + "flights");
            System.out.println(flightReservationSystem.getListOfAllFlights() 
                    + "\n");
            flightDeparture = input.nextLine();
            for (Flight flight : flightReservationSystem.getHashSetOfFlight()) {
                if (flightDeparture.equals(flight.getFlightTime())) {
                    falseValue = false;
                }
            }
            if (falseValue) {
                System.out.println("Please enter one of the valid flights");
            }
        }

        falseValue = true;
        while (falseValue) {
            System.out.println("Please select desired seat for flight");
            System.out.println("Here is a list of all the currently available "
                    + "seats:");
            System.out.println(flightReservationSystem.getListOfAllAvailableSeats(flightDeparture)
                    + "\n");
            seatOnFlight = input.nextLine();

            for (Seat seat : flightReservationSystem.getArrayListOfAllSeats(flightDeparture)) {
                if (seat.getSeatId().equals(seatOnFlight) && seat.isAvailable()) {
                    falseValue = false;
                }
            }
            if (falseValue) {
                System.out.println("Please enter one of the valid seats");
            }
        }

        falseValue = true;
        flightReservationSystem.doSellTicket(fullName, flightDeparture, 
                seatOnFlight);

    }

    /**
     * lists all seats in the desired flight.
     */
    void doListSeatsInFlight() {

        String flightTime = "";

        falseValue = true;
        while (falseValue) {
            System.out.println("doListSeatsInFlight() was called");
            System.out.println("Get a list of all seats by typing the flight "
                    + "departure:");
            System.out.println("Here is a list of all created flights: " 
                    + flightReservationSystem.getListOfAllFlights());
            flightTime = input.nextLine();
            for (Flight flight : flightReservationSystem.getHashSetOfFlight()) {
                if (flight.getFlightTime().equals(flightTime)) {
                    falseValue = false;
                }
            }
            if (falseValue) {
                System.out.println("Please enter one of the listed flights");
            }
        }
        System.out.println(flightReservationSystem.doListSeatsInFlight(flightTime));
    }

    /**
     * List all passenger in the desired flight.
     */
    void doListPassengersInFlight() {
        String flightTime = "";
        while (falseValue) {
            System.out.println("doListPassengersInFlight() was called");
            System.out.println("Get a list of all passenger on flight by "
                    + "typing the flight departure:");
            System.out.println("Here is a list of all created flights: " 
                    + flightReservationSystem.getListOfAllFlights());
            flightTime = input.nextLine();
            if (Pattern.matches(".*[0-9]", flightTime)) {
                falseValue = false;
            } 
            else 
            {
                System.out.println("That flight does not exist, try to only "
                        + "use numbers");
            }
        }
        System.out.println(flightReservationSystem.doListPassengersInFlight(flightTime));
    }

    /**
     * List all passengers in the passengerRegister.
     */
    void doListAllPassengers() {
        System.out.println(flightReservationSystem.getListOfAllPassengers());
    }

    /**
     * List all flights in the flightRegister.
     */
    void doListAllFlights() {
        System.out.println(flightReservationSystem.getListOfAllFlights());
    }

}
