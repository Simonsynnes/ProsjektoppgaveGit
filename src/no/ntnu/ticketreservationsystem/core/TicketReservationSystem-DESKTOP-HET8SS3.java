/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.core;

import no.ntnu.ticketreservationsystem.enteties.Ticket;
import no.ntnu.ticketreservationsystem.enteties.Seat;
import no.ntnu.ticketreservationsystem.enteties.Plane;
import no.ntnu.ticketreservationsystem.enteties.Flight;
import java.util.ArrayList;
import java.util.HashSet;
import no.ntnu.ticketreservationsystem.enteties.Passenger;

/**
 * Makes the most important classes and initialize them to call for their data.
 *
 * @version 1
 * @author Olav
 */
public class TicketReservationSystem {

    private FlightRegister flightRegister;
    private PassengerRegister passengerRegister;
    private TicketRegister ticketRegister;
    private PlaneRegister planeRegister;

    /**
     * makes the lists
     */
    public TicketReservationSystem() {
        flightRegister = new FlightRegister();
        passengerRegister = new PassengerRegister();
        ticketRegister = new TicketRegister();
        planeRegister = new PlaneRegister();
    }

    /**
     *
     * @param name
     * @param description
     * @param seatWithinRow
     * @param numberOfSeatRows
     * @param maxPilots
     * @param maxCrew
     */
    public void doCreateNewPlane(String name, String description, 
            int seatWithinRow, int numberOfSeatRows, int maxPilots, 
            int maxCrew) {
        planeRegister.addPlane(name, description, seatWithinRow, 
                numberOfSeatRows, maxPilots, maxCrew);
    }

    /**
     * creates a flight and adds it into the flights list.
     *
     * @param flightID
     * @param departureHour
     * @param plane planeType desired
     * @param arrivalHour
     * @param departureMin
     * @param arrivalMin
     */
    public void doCreateFlight(String flightID, int departureHour, 
            int departureMin, int arrivalHour, int arrivalMin, int plane) {
        flightRegister.addFlight(flightID, departureHour, departureMin, 
                arrivalHour, arrivalMin, 
                planeRegister.getListWithAllPlanes().get(plane - 1));
    }

    /**
     * Register a new passenger
     *
     * @param firstName get persons first name
     * @param lastName get persons last name
     * @param eMail get persons email
     */
    
    public void doRegisterPassenger(String firstName, String lastName, String eMail) {
        passengerRegister.addNewPassenger(firstName, lastName, eMail);
    }
    
    /**
     * Register a new passenger
     *
     * @param firstName get persons first name
     * @param lastName get persons last name
     * @param eMail get persons email
     * @param employeeNumber get persons employee number
     * @param sertificate get persons sertificate
     */
    
    public void doRegisterPilot(String firstName, String lastName, String eMail, 
            String employeeNumber, String sertificate) {
        passengerRegister.addNewPilot(firstName, lastName, eMail, 
                employeeNumber, sertificate);
    }
    
    /**
     * Register a new passenger
     *
     * @param firstName get persons first name
     * @param lastName get persons last name
     * @param eMail get persons email
     * @param employeeNumber get persons employee number
     */
    
    public void doRegisterCrew(String firstName, String lastName, String eMail, 
            String employeeNumber) {
        passengerRegister.addNewCrew(firstName, lastName, eMail, employeeNumber);
    }
    
    /**
     * Register Pilot to plane
     * 
     * @param flightID
     * @param fullName
     * @return 
     */
    
    public boolean doRegisterPilotCrewtToFlight(String flightID, String fullName) {
        
        Passenger passenger = null;
        Flight flightForPilot = null; 
        
        for(Flight flight : flightRegister.getFlightList()) {
            if(flightID.equals(flight.getFlightID())) {
                flightForPilot = flight;
            }
        }
        
        for(Passenger pass : passengerRegister.getPassengerList()) {
            if(fullName.equals(pass.getFullName())) {
                passenger = pass;
            }
        }
        
        if(passenger.getOccupation().equals("pilot")){
            flightForPilot.getPlaneCrewRegister().addPilot(passenger);
        } else if (passenger.getOccupation().equals("crew")) {
            flightForPilot.getPlaneCrewRegister().addCrew(passenger);
        } else {
            return false;
        }  
        return true;
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
                if (fli.getDepartureTime().equals(departure)) {
                    flight = fli;
                }
            }
        }
        if (!passengerRegister.getPassengerList().isEmpty()) {
            for (Passenger pas : passengerRegister.getPassengerList()) {
                if (pas.getFullName().equals(fullName)) {
                    passenger = pas;
                }
            }
        }

        if (flight != null) {
            for (Seat seatPos : flight.getSeatRegister().getArrayListOfSeats()) {
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
     * @param input
     * @return a string with a list og all the seats in the flight
     */
    public String doListSeatsInFlight(String input) {

        String SeatInFlight = "";

        for (Flight fly : flightRegister.getFlightList()) {
            if (fly.getDepartureTime().equals(input)) {
                SeatInFlight = fly.listAllSeatsInPlane();
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

    /**
     * returns a string with all persons with no role.
     *
     * @return a long string
     */
    public String getListOfAllPersons() {
        String listString = "";
        for (Passenger person : getHashSetOfPassenger()) {
                listString += "Name: " + person.getFullName() + "     Email: " 
                        + person.getEmailAddress() +  "     occupation: " 
                        + person.getOccupation() + "\n";
        }
        return listString;
    }

    /**
     * turns the list of planes into a string.
     *
     * @return a long string
     */
    public String getListOfAllPlanes() {
        int index = 1;
        String listString = "";
        for (Plane plane : getArrayListOfPlane()) {
            listString += "" + index + ". " + plane.getName() + "\n";
            index++;
        }
        return listString;
    }

    /**
     * Gets a list of all available seats. uses a for-eash because there might
     * be many planes with the same flight time.
     *
     * @param flight
     * @return
     */
    public String getListOfAllAvailableSeats(String flight) {
        String listOfAllAvailableSeats = "";
        for (Flight fly : flightRegister.getFlightList()) {
            if (fly.getDepartureTime().equals(flight)) {
                listOfAllAvailableSeats
                        += fly.listAllAvailableSeatsInPlane();
            }
        }
        return listOfAllAvailableSeats;
    }

    /**
     *
     * @return
     */
    public HashSet<Flight> getListOfFlights() {
        return flightRegister.getFlightList();
    }

    /**
     *
     * @return
     */
    public HashSet<Passenger> getHashSetOfPassenger() {
        return passengerRegister.getPassengerList();
    }

    /**
     *
     * @return
     */
    public ArrayList<Plane> getArrayListOfPlane() {
        return planeRegister.getListWithAllPlanes();
    }

    /**
     *
     * @return
     */
    public int getTotalNumberOfPlanes() {
        return planeRegister.getListWithAllPlanes().size();
    }

    /**
     *
     * @param departure
     * @return
     */
    public ArrayList<Seat> getArrayListOfAllSeats(String departure) {
        for (Flight fly : getListOfFlights()) {
            if (fly.getDepartureTime().equals(departure)) {
                return fly.getSeatRegister().getArrayListOfSeats();
            }
        }
        return null;
    }
    
    /**
     *
     * @param passenger
     */
    public void doRegisterPassengerAsPassenger(Passenger passenger) {
        String firstName = passenger.getFirstName();
        String lastName = passenger.getLastName();
        String email = passenger.getEmailAddress();
        passengerRegister.removePassenger(passenger);
        passengerRegister.addNewPassenger(firstName, lastName, email);
    }
    
    /**
     *
     * @param passenger
     * @param employeeNumber
     * @param sertificate
     */
    public void doRegisterPassengerAsPilot(Passenger passenger, String employeeNumber, String sertificate) {
        String firstName = passenger.getFirstName();
        String lastName = passenger.getLastName();
        String email = passenger.getEmailAddress();
        passengerRegister.removePassenger(passenger);
        passengerRegister.addNewPilot(firstName, lastName, email, employeeNumber, sertificate);
    }
    
    /**
     *
     * @param passenger
     * @param employeeNumber
     */
    public void doRegisterPassengerAsCrew(Passenger passenger, String employeeNumber) {
        String firstName = passenger.getFirstName();
        String lastName = passenger.getLastName();
        String email = passenger.getEmailAddress();
        passengerRegister.removePassenger(passenger);
        passengerRegister.addNewCrew(firstName, lastName, email, employeeNumber);
    }
}
