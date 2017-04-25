/*
 * Makes a seatregister a with a given number of seats. The flight represent the
 */
package no.ntnu.ticketreservationsystem.enteties;

import java.util.ArrayList;
import no.ntnu.ticketreservationsystem.core.PlaneCrewRegister;
import no.ntnu.ticketreservationsystem.core.SeatRegister;

/**
 * Flight is a departure, a time. This means that there is many times and a
 * preset different kinds og planes. There are 3 differen plane sizes.
 * @author Olav
 */

public class Flight {
    
    private String flightID;
    private int departureHour;
    private int departureMin;
    private int arrivalHour;
    private int arrivalMin;
    private String departure;
    private String arrival;
    private Plane plane;
    private SeatRegister seats;
    private PlaneCrewRegister planeCrewRegister;
    
    /**
     * makes a flight with a decided size.
     * @param flightID
     * @param departureHour
     * @param arrivalMin
     * @param arrivalHour
     * @param departureMin
     * @param plane
     */
    
    public Flight(String flightID, int departureHour, int departureMin, 
            int arrivalHour, int arrivalMin, Plane plane) {
        this.flightID = flightID;
        this.departureHour = departureHour;
        this.departureMin = departureMin;
        this.arrivalHour = arrivalHour;
        this.arrivalMin = arrivalMin;
        departure = String.format("%02d", departureHour) + ":" + String.format("%02d", departureMin);
        arrival = String.format("%02d", arrivalHour) + ":" + String.format("%02d", arrivalMin);
        this.plane = plane;
        seats = new SeatRegister(plane.getSeatsWithinRow(), 
                plane.getNumberOfSeatRows());
        planeCrewRegister = new PlaneCrewRegister(plane.getMaxPilot(),
                plane.getMaxCrew());
    }
    
    /**
     *
     * @return
     */
    public String getFlightID() {
        return flightID;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getArrival() {
        return arrival;
    }
    
    /**
     *
     * @return
     */
    public String getDepartureHourString() {
        return String.format("%02d", departureHour);
    }
    
    /**
     *
     * @return
     */
    public int getDepartureHour() {
        return departureHour;
    }
    
    /**
     *
     * @return
     */
    public String getDepartureMinuteString() {
        return String.format("%02d", departureMin);
    }
    
    /**
     *
     * @return
     */
    public int getDepartureMinute() {
        return departureMin;
    }
    
    /**
     *
     * @return
     */
    public String getArrivalHourString() {
        return String.format("%02d", arrivalHour);
    }
    
    /**
     *
     * @return
     */
    public int getArrivalHour() {
        return arrivalHour;
    }
    
    /**
     *
     * @return
     */
    public String getArrivalMinuteString() {
        return String.format("%02d", arrivalMin);
    }
    
    /**
     *
     * @return
     */
    public int getArrivalMinute() {
        return arrivalMin;
    }
    
    /**
     * get's the flights ID.
     * @return string flightid.
     */
    
    public String getDepartureTime() {
        return getDepartureHourString() + ":" + getDepartureMinuteString();
    }
    
    /**
     *
     * @return
     */
    public String getArrivalTime() {
        return getArrivalHourString() + ":" + getArrivalMinuteString();
    }
    
    /**
     *
     * @return
     */
    public Plane getPlane() {
        return plane;
    }
    
    /**
     * gets the seatRegister
     *
     * @return seatRegister that is a class that holds seats.
     */
    public SeatRegister getSeatRegister() {
        return seats;
    }
    
    /**
     * list all the seats and sets the unavailable seats as X
     *
     * @return a string with all available seats.
     */
    public String listAllAvailableSeatsInPlane() {
        return seats.listAllAvailableSeats();
    }
    
    /**
     * list all seat in flight as a long string.
     *
     * @return a string with all the seats in this flight
     */
    public String listAllSeatsInPlane() {
        return seats.listAllSeats();
    }
    
    /**
     * gets the planeCrewRegister
     * 
     * @return planeCrewRegister that holds Pilots and Crew
     */
    
    public PlaneCrewRegister getPlaneCrewRegister() {
        return planeCrewRegister;
    }
}
