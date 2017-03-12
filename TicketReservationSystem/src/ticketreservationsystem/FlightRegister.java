/*
 * Contains the all the flights. Used too send info to application in number og 
 * flights and the list of seats.
 */
package ticketreservationsystem;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @version 1
 * @author Olav
 */
public class FlightRegister {
    
    private HashSet<Flight> flights;
    
    /**
     * creates a new hashset of Flight.
     */
    
    public FlightRegister() {
        flights = new HashSet<>();
    }
    
    /**
     * get the listOfFlight and returns it.
     * @return flights list.
     */
    
    public HashSet<Flight> getFlightList() {
        return flights;
    }    
    
    /**
     * turns the list into a list of strings.
     * @return flights as String
     */
    
    public String getListOfAllFlights() {
        String listString = "";
        for (Flight flight : flights) {
            listString += flight.getFlightTime() + "\n";
        }
        return listString;
    }
    
    public void addFlight(int hour, int minute, Plane plane) {
        flights.add(new Flight(hour, minute, plane)); 
    }
    
    public ArrayList<Seat> getArrayListOfAllSeats(String time) {
        for(Flight fly : flights) {
            if(fly.getFlightTime().equals(time)) {
                return fly.getSeatArray();
            }
        }
        return null;
    }
    
}
