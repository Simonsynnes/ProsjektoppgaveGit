/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.enteties;

/**
 *
 * @author olavt
 */
public class Crew extends Passenger {
    
    String employeeNumber;    
    
    public Crew(String lastName, String surName, String emailAddress, 
            String employeeNumber) {
        super(lastName, surName, emailAddress);
        this.employeeNumber = employeeNumber;
    }
    
    public String getEmplyeeNumber() {
        return employeeNumber;
    }
    
    /**
     * get the ooccupation.
     * @return String with occupation
     */
    @Override
    public String getOccupation() {
        return "crew";
    }
}
