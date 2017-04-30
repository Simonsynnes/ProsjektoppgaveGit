/*
 * 
 */
package no.ntnu.ticketreservationsystem.core;

import java.util.ArrayList;
import no.ntnu.ticketreservationsystem.enteties.Ticket;
import no.ntnu.ticketreservationsystem.enteties.Seat;
import no.ntnu.ticketreservationsystem.enteties.Passenger;
import no.ntnu.ticketreservationsystem.enteties.Flight;

/**
 * 
 * @author Olav
 */
public class TicketRegister {
    
    private ArrayList<Ticket> tickets;
    
    public TicketRegister() {
        tickets = new ArrayList<>();
    }
    
    public String getTicketPassengerAndSeat() {
        String passengerOnSeat = ""; 
        for(Ticket ticket : tickets) {
             passengerOnSeat += ticket.getPassenger().getFullName() + " " + ticket.getSeat().getSeatId() + "\n";
        }
        return passengerOnSeat;
    }
    
    public ArrayList<Ticket> getTicketList() {
        return tickets;
    }
    
    public void addTicket(Flight flight, Passenger person, Seat seat) {
        tickets.add(new Ticket(flight, person, seat));
    }
}