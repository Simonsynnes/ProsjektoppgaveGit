package no.ntnu.ticketreservationsystem.core;

import no.ntnu.ticketreservationsystem.enteties.Seat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Represent a collection of seats in an ariplane. Provides functionality for
 * adding, removing, and searching among seats.
 *
 * @author (Olav Telseth, Simon Synnes and Einar Weltan)
 * @version (a version number or a date)
 */
public class SeatRegister {

    /**
     * makes a seatRegister.
     */

    private ArrayList<Seat> seats; //the seat register.
    private ArrayList<String> seatsWithInRowList;
    private int numberOfSeatRows;
    String allPosistionsWithinRow[];

    /**
     * Constructor for objects of class SeatRegister - call the private method
     * fillWithSeat, fills the register with seats.
     */
    public SeatRegister(int seatsWithinRow, int numberOfSeatRows) {
        this.numberOfSeatRows = numberOfSeatRows;
        this.seats = new ArrayList<>();
        allPosistionsWithinRow = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P" };
        seatsWithInRowList = new ArrayList<>();
        for(int index = 0; index < seatsWithinRow; index++) {
            seatsWithInRowList.add(allPosistionsWithinRow[index]);
        }
        fillWithSeatsForFlight();
        
    }

    /**
     * add seats to the register.
     *
     * @param seat a Seat object
     */
    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }
    
    public ArrayList<Seat> getArrayListOfSeats() {
        return seats;
    }

    /**
     * removes seat with the given seatId.
     *
     * @param seatId seatId
     */
    public void removeSeat(String seatId) {
        Iterator<Seat> it = this.seats.iterator();
        boolean found = false;
        while (it.hasNext() && !found) {
            Seat seat = it.next();
            if ((seat.getSeatId()).equals(seatId)) {
                System.out.println("removing seat: " + seatId);
                it.remove();
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
    }

    /**
     * Gets seat based on ID.
     *
     * param seatId the seatId
     * @return the Seat based on seatId
     */
    public Seat getSeatById(String seatId) {
        Iterator<Seat> it = this.seats.iterator();
        boolean found = false;
        Seat foundSeat = null;
        while (it.hasNext() && !found) {
            Seat seat = it.next();
            if (seat.getSeatId().equals(seatId)) {
                found = true;
                foundSeat = seat;
            }
        }
        return foundSeat;
    }

    /**
     * skriver ut antall seter i registeret.
     *
     * @return the number of seats
     */
    public int getNumberOfSeats() {
        int numberOfSeats = this.seats.size();
        return numberOfSeats;
    }

    /**
     * Henter antall ledige seter.
     *
     * @return the numberOfAvailableSeats
     */
    public int geNumberOfAvailableSeats() {
        int numberOfAvailableSeats = 0;
        for (Seat seat : this.seats) {
            if (seat.isAvailable()) {
                numberOfAvailableSeats++;
            }
        }
        return numberOfAvailableSeats;
    }

    /**
     * Skriver ut alle setene som er i registeret.
     */
    public String listAllAvailableSeats() {
        String allSeatString = "";
        int index = 0;
        for (Seat seat : this.seats) {
            if(seat.isAvailable()) {
                allSeatString += seat.getSeatId() + " ";
            } else {
                allSeatString += " X ";
            }
            
            if(seatsWithInRowList.get(seatsWithInRowList.size()/2-1).equals(seat.getSeatPosWithinRow())) {
                allSeatString += "  ";
            }
            index++;
            if(index >= seatsWithInRowList.size()) {
                allSeatString += "\n";
                index = 0;
            }
        }
        return allSeatString;
    }
    
    public String listAllSeats() {
        String allSeatString = "";
        int index = 0;
        for (Seat seat : this.seats) {
            allSeatString += seat.getSeatId() + " ";
            if(seatsWithInRowList.get(seatsWithInRowList.size()/2-1).equals(seat.getSeatPosWithinRow())) {
                allSeatString += "  ";
            }
            index++;
            if(index >= seatsWithInRowList.size()) {
                allSeatString += "\n";
                index = 0;
            }
        }
        return allSeatString;
    }

    /**
     * En privat metode for å fylle opp registeret (bare for testing).
     */
    
    private void fillWithSeatsForFlight() {
        for(int seatRow = 1; seatRow <= numberOfSeatRows; seatRow++) {
            for(int index = 0; index < seatsWithInRowList.size(); index++) {
                seats.add(new Seat(seatRow, seatsWithInRowList.get(index)));
            }
        }    
    }
}
