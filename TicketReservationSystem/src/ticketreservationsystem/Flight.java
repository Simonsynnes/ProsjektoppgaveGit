/*
 * Makes a seatregister a with a given number of seats. The flight represent the
 */
package ticketreservationsystem;

import java.util.ArrayList;

/**
 * Flight is a departure, a time. This means that there is many times and a
 * preset different kinds og planes. There are 3 differen plane sizes.
 * @author Olav
 */

public class Flight {
    
    private int flightHour;
    private int flightMin;
    private Plane plane;
    
    /**
     * makes a flight with a decided size.
     * @param flightHour sets the flight's hour of departure
     * @param flightMin sets the flight's minute of departure
     * @param plane sets type plane tha flight have
     */
    
    public Flight(int flightHour, int flightMin, Plane plane) {
        this.flightHour = flightHour;
        this.flightMin = flightMin;
        this.plane = plane;
    }
    
    public String getFlightHourString() {
        return String.format("%02d", flightHour);
    }
    
    public String getFlightMinuteString() {
        return String.format("%02d", flightMin);
    }
    
    /**
     * get's the flights Time.
     * @return string flightid.
     */
    
    public String getFlightTime() {
        return getFlightHourString() + ":" + getFlightMinuteString();
    }
    
    public Plane getPlane() {
        return plane;
    }
    
    public ArrayList<Seat> getSeatArray() {
        return plane.getSeatRegister().getArrayListOfSeats();
    }
}
