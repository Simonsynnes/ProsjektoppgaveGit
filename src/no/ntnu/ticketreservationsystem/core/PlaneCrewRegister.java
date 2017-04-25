/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.core;

import java.util.HashSet;
import no.ntnu.ticketreservationsystem.enteties.Passenger;

/**
 *
 * @author Olav
 */
public class PlaneCrewRegister {
    
    private int maxPilots;
    private int maxCrew;
    private HashSet<Passenger> pilots;
    private HashSet<Passenger> crews;
    
    public PlaneCrewRegister(int maxPilots, int maxCrew) {
        this.maxPilots = maxPilots;
        this.maxCrew = maxCrew;
    }
    
    public int getMaxPilots() {
        return maxPilots;
    }
    
    public int getMaxCrew() {
        return maxCrew;
    }
    
    public HashSet<Passenger> getPilotOnPlaneList() {
        return pilots;
    }
    
    public HashSet<Passenger> getCrewOnPlaneList() {
        return crews;
    }
    
    public boolean addPilot(Passenger passenger) {
        if(pilots.size() < maxPilots) {
            pilots.add(passenger);
            return true;
        }
        return false;
    }
    
    public boolean addCrew(Passenger passenger) {
        if(crews.size() < maxCrew) {
            crews.add(passenger);
            return true;
        }
        return false;
    }
} 
