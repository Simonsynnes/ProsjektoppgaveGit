package no.ntnu.ticketreservationsystem.enteties;


/**
 * Represent a seat in an airplane. Seats in an aiplane are
 * identified by a row and a place in the row gicven by a
 * letter "A" to "I"
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Seat {

    /**
     * @param seatRow sets what searrow the seat is in
     * @param seatPosWithinRow seat what posistion the seat is within the
     * seatrow
     * @param available sets the seat available
     */
    private int seatRow; //seatRow
    private String seatPosWithinRow; //seatPosWithinRow
    private boolean available; //available

    /**
     * Constructor for objects of class Seat.
     *
     * @param seatRow set the seatRow
     * @param seatPosWithinRow sets the seatRowWithinRow
     */
    public Seat(int seatRow, String seatPosWithinRow) {
        // initialise instance variables
        this.seatRow = seatRow; // seatrow
        this.seatPosWithinRow = seatPosWithinRow; // seatrow
        this.available = true;
    }

    /**
     * sjekker om setet er ledig.
     *
     * @return a boolean value
     */
    public boolean isAvailable() {
        return this.available;
    }

    /**
     * Get the seat by pinting out the ID.
     *
     * @return a String vale
     */
    public String getSeatId() {
        return "" + seatRow + seatPosWithinRow;
    }
    
    public String getSeatPosWithinRow() {
        return seatPosWithinRow;
    }

    /**
     * Sets the object to unavaiable.
     */
    public void setUnavailable() {
        this.available = false;
    }
}
