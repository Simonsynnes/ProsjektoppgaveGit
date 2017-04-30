/*
 * Represent a ticket. A ticket get info from flight and
 */
package no.ntnu.ticketreservationsystem.enteties;

import no.ntnu.ticketreservationsystem.enteties.Seat;
import no.ntnu.ticketreservationsystem.enteties.Passenger;
import no.ntnu.ticketreservationsystem.enteties.Flight;
import no.ntnu.ticketreservationsystem.enteties.Passenger;

/**
 * @version (versjon)
 * @author Olav
 */
public class Ticket {
    private Passenger person;
    private Flight flight;
    private Seat seat;
    private String name;
    private String departure;
    private String seatID;
    
    public Ticket(Flight flight, Passenger person, Seat seat) {
        this.flight = flight;
        this.person = person;
        this.seat = seat;
        this.seat.setUnavailable();
        seatID = seat.getSeatId();
        departure = flight.getDepartureTime();
        name = person.getFullName();
    }

    public String getName() {
        return name;
    }

    public String getDeparture() {
        return departure;
    }

    public String getSeatID() {
        return seatID;
    }
    
    public Flight getFlight() {
        return flight;
    }
    
    /**
     * get the flights id
     * @return flight id
     */
    
    public String getFlightId() {
        return flight.getDepartureTime();
    }
    
    /**
     * get's what seat this ticket is bound too.
     * @return the seat variable
     */
    
    public Seat getSeat() {
        return seat;
    }
    
    /**
     * get the passanger that currently has the ticket.
     * @return the passenger variable
     */
    
    public Passenger getPassenger() {
        return person;
    }
    
    /**
     * get the full name of the passenger currently holding the ticket.
     * @return full name of passenger
     */
    
    public String getPassengerFullName() {
        return person.getFullName();
    }
}
