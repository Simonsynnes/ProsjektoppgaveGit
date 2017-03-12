/*
 * 
 */
package ticketreservationsystem;

import java.util.HashSet;

/**
 * 
 * @author Olav
 */
public class TicketRegister {
    
    private HashSet<Ticket> tickets;
    
    public TicketRegister() {
        tickets = new HashSet<>();
    }
    
    public String getTicketPassengerAndSeat() {
        String passengerOnSeat = ""; 
        for(Ticket ticket : tickets) {
             passengerOnSeat += ticket.getPassenger().getFullName() + " " + ticket.getSeat().getSeatId() + "\n";
        }
        return passengerOnSeat;
    }
    
    public HashSet<Ticket> getTicketList() {
        return tickets;
    }
    
    public void addTicket(Flight flight, Passenger passenger, Seat seat) {
        tickets.add(new Ticket(flight, passenger, seat));
    }
}