/*
 * Contains the all the flights. Used too send info to application in number og 
 * flights and the list of seats.
 */
package no.ntnu.ticketreservationsystem.core;

import java.util.ArrayList;
import no.ntnu.ticketreservationsystem.enteties.Flight;
import java.util.HashSet;
import no.ntnu.ticketreservationsystem.enteties.Plane;

/**
 * @version 1
 * @author Olav
 */
public class FlightRegister {
    
    private ArrayList<Flight> flights;
    
    /**
     * creates a new hashset of Flight.
     */
    
    public FlightRegister() {
        flights = new ArrayList<>();
    }
    
    /**
     * get the listOfFlight and returns it.
     * @return flights list.
     */
    
    public ArrayList<Flight> getFlightList() {
        return flights;
    }    
        
    public void addFlight(String flightID, int departureHour, int departureMin,
            int arrivalHour, int arrivalMin, Plane plane) {
        flights.add(new Flight(flightID, departureHour, departureMin,
                arrivalHour, arrivalMin, plane)); 
    }    
}
