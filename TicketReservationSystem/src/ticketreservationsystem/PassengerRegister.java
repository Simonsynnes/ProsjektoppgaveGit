/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketreservationsystem;

import java.util.HashSet;

/**
 *
 * @author Olav
 */
public class PassengerRegister {
    
    private HashSet<Passenger> passengers;
    
    public PassengerRegister() {
        passengers = new HashSet<>();
    }
    
    public HashSet<Passenger> getPassengerList() {
        return passengers;
    }
    
    public void addNewPassenger(String surName, String lastName, String eMail) {
        passengers.add(new Passenger(surName, lastName, eMail));
    }
    
    public String listAllPassengers() {
        String listString = "";
        int passengerNumber = 1;
        for(Passenger passenger : passengers) {
            listString += "" + passengerNumber + ". " + passenger.getFullName() + "\n";
            passengerNumber++;
        }
        return listString;
    }
}
