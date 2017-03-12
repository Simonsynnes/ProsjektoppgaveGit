/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservationsystem;

/**
 *
 * @author Olav
 */
public class Plane { 
    private String name;
    private String description;
    private int seatsWithinRow;
    private int numberOfSeatRows;
    private SeatRegister seats;
    
    public Plane(String name, String description, int seatsWithinRow, int numberOfSeatRows) {
        this.name = name;
        this.description = description;
        this.numberOfSeatRows = numberOfSeatRows;
        this.seatsWithinRow = seatsWithinRow;
        seats = new SeatRegister(seatsWithinRow, numberOfSeatRows);
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * gets the seatRegister
     * @return seatRegister that is a class that holds seats.
     */
    
    public SeatRegister getSeatRegister() {
        return seats;
    }
    
    /**
     * list all seat in flight as a long string.
     * @return a string with all the seats in this flight
     */
    
    public String listAllSeatsInPlane() {
        return seats.listAllSeats();
    }
    
    /**
     * list all the seats and sets the unavailable seats as X
     * @return a string with all available seats.
     */
    
    public String listAllAvailableSeatsInPlane() {
        return seats.listAllAvailableSeats();
    }
}
