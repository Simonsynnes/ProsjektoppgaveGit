/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.enteties;

import java.util.ArrayList;
import no.ntnu.ticketreservationsystem.core.PlaneCrewRegister;
import no.ntnu.ticketreservationsystem.core.SeatRegister;

/**
 *
 * @author Olav
 */
public class Plane {

    private String name;
    private String description;
    private int seatsWithinRow;
    private int numberOfSeatRows;
    private int maxPilots;
    private int maxCrew;

    public Plane(String name, String description, int seatsWithinRow, int numberOfSeatRows, int maxPilots, int maxCrew) {
        this.name = name;
        this.description = description;
        this.numberOfSeatRows = numberOfSeatRows;
        this.seatsWithinRow = seatsWithinRow;
        this.maxPilots = maxPilots;
        this.maxCrew = maxCrew;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getSeatsWithinRow() {
        return seatsWithinRow;
    }
    
    public int getNumberOfSeatRows() {
        return numberOfSeatRows;
    }
    
    public int getMaxPilot() {
        return maxPilots;
    }
    
    public int getMaxCrew() {
        return maxCrew;
    }
}
