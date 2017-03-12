/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservationsystem;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Makes the most important classes and initialize them to call for their data.
 *
 * @version 1
 * @author Olav
 */
public class FlightReservationSystem {

    private FlightRegister flightRegister;
    private PassengerRegister passengers;
    private TicketRegister ticketRegister;
    private PlaneRegister planeRegister;

    /**
     * makes the lists
     */
    public FlightReservationSystem() {
        flightRegister = new FlightRegister();
        passengers = new PassengerRegister();
        ticketRegister = new TicketRegister();
        planeRegister = new PlaneRegister();
    }
    
    public void doCreateNewPlane(String name, String description, int seatWithinRow, int numberOfSeatRows) {
        planeRegister.addPlane(name, description, seatWithinRow, numberOfSeatRows);
    }

    /**
     * creates a flight and adds it into the flights list.
     *
     * @param time get's the departure inputted
     * @param plane planeType desired
     */
    public void doCreateFlight(int hour, int minute, int plane) {
        flightRegister.addFlight(hour, minute, planeRegister.getListWithAllPlanes().get(plane-1));
    }

    /**
     * Register a new passenger
     *
     * @param firstName get persons first name
     * @param lastName get persons last name
     * @param eMail get persons email
     */
    public void doRegisterPassenger(String firstName, String lastName, String eMail) {
        passengers.addNewPassenger(firstName, lastName, eMail);
    }

    /**
     * Sells a ticket to the given person and the selected flight.
     *
     * @param fullName get passengers full name
     * @param departure get the desired departure
     * @param seatId get the desired seat
     */
    public void doSellTicket(String fullName, String departure, String seatId) {
        Flight flight = null;
        Passenger passenger = null;
        Seat seat = null;

        //For løkkene sjekker om inputten er lik noe av de flyavgangene og 
        //passasjerene som er registrert.
        if (!flightRegister.getFlightList().isEmpty()) {
            for (Flight fli : flightRegister.getFlightList()) {
                if (fli.getFlightTime().equals(departure)) {
                    flight = fli;
                }
            }
        }
        if (!passengers.getPassengerList().isEmpty()) {
            for (Passenger pas : passengers.getPassengerList()) {
                if (pas.getFullName().equals(fullName)) {
                    passenger = pas;
                }
            }
        }

        if (flight != null) {
            for (Seat seatPos : flight.getPlane().getSeatRegister().getArrayListOfSeats()) {
                if (seatPos.getSeatId().equals(seatId)) {
                    seat = seatPos;
                }
            }
        }
        if ((flight != null) && (passenger != null) && (seat != null)) {
            ticketRegister.addTicket(flight, passenger, seat);
        }
    }

    /**
     * lists all the seat on the given flight.
     *
     * @return a string with a list og all the seats in the flight
     */
    public String doListSeatsInFlight(String input) {

        String SeatInFlight = "";

        for (Flight fly : flightRegister.getFlightList()) {
            if (fly.getFlightTime().equals(input)) {
                SeatInFlight = fly.getPlane().listAllSeatsInPlane();
            }
        }

        return SeatInFlight;
    }

    /**
     * List all passenger on the inputted flight.
     *
     * @param input
     * @return passenger full name
     */
    public String doListPassengersInFlight(String input) {
        String passengerOnFlightString = "";

        for (Ticket ticket : ticketRegister.getTicketList()) {
            if (ticket.getFlightId().equals(input)) {
                passengerOnFlightString += (ticket.getPassengerFullName() + " \n");
            }
        }
        return passengerOnFlightString;
    }

    public String getListOfAllPassengers() {
        return passengers.listAllPassengers();
    }

    public String getListOfAllFlights() {
        return flightRegister.getListOfAllFlights();
    }
    
    public String getListOfAllPlanes() {
        return planeRegister.getStringOfAllPlanes();
    }
    
    /**
     * Gets a list of all available seats. uses a for-eash because there might
     * be many planes with the same flight time.
     * @param flight
     * @return 
     */

    public String getListOfAllAvailableSeats(String flight) {
        String listOfAllAvailableSeats = "";
        for (Flight fly : flightRegister.getFlightList()) {
            if (fly.getFlightTime().equals(flight)) {
                listOfAllAvailableSeats += fly.getPlane().listAllAvailableSeatsInPlane();
            }
        }
        return listOfAllAvailableSeats;
    }
    
    public HashSet<Flight> getHashSetOfFlight() {
        return flightRegister.getFlightList();
    }
    
    public HashSet<Passenger> getHashSetOfPassenger() {
        return passengers.getPassengerList();
    }
    
    public int getTotalNumberOfPlanes() {
        return planeRegister.getListWithAllPlanes().size();
    }
    
    public ArrayList<Seat> getArrayListOfAllSeats(String departure) {
        return flightRegister.getArrayListOfAllSeats(departure);
    }
}
