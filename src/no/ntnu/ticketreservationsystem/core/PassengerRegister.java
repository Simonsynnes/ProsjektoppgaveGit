/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.core;

import java.util.ArrayList;
import no.ntnu.ticketreservationsystem.enteties.Passenger;
import no.ntnu.ticketreservationsystem.enteties.Crew;
import no.ntnu.ticketreservationsystem.enteties.EmailFormatException;
import no.ntnu.ticketreservationsystem.enteties.Pilot;

/**
 *
 * @author Olav
 */
public class PassengerRegister {
    
    private ArrayList<Passenger> passengers;
    
    public PassengerRegister() {
        passengers = new ArrayList<>();
    }
    
    public ArrayList<Passenger> getPassengerList() {
        return passengers;
    }
    
    public void addNewPassenger(String firstName, String lastName, String eMail) throws EmailFormatException {
        passengers.add(new Passenger(firstName, lastName, eMail));
    }
        
    public void addNewPilot(String firstName, String lastName, 
            String eMail, String employeeNumber, String sertificate) throws EmailFormatException {
        passengers.add(new Pilot(firstName, lastName, eMail, employeeNumber, sertificate));
    }
    
    public void addNewCrew(String firstName, String lastName, String eMail,
            String employeeNumber) throws EmailFormatException {
        passengers.add(new Crew(firstName, lastName, eMail, employeeNumber));
    }
    
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
}
