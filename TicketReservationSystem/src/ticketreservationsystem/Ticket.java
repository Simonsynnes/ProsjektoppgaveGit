/*
 * Represent a ticket. A ticket get info from flight and
 */
package ticketreservationsystem;

/**
 * @version (versjon)
 * @author Olav
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private Seat seat;
    
    public Ticket(Flight flight, Passenger passenger, Seat seat) {
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.seat.setUnavailable();
    }
    
    public Flight getFlight() {
        return flight;
    }
    
    /**
     * get the flights id
     * @return flight id
     */
    
    public String getFlightId() {
        return flight.getFlightTime();
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
        return passenger;
    }
    
    /**
     * get the full name of the passenger currently holding the ticket.
     * @return full name of passenger
     */
    
    public String getPassengerFullName() {
        return passenger.getFullName();
    }
}
