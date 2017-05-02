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
public class Pilot extends Passenger {
    
    private String sertificate;
    private String employeeNumber;
    
    public Pilot(String lastName, String surName, String emailAddress, 
            String employeeNumber, String sertificate) throws EmailFormatException {
        super(lastName, surName, emailAddress);
        this.employeeNumber = employeeNumber;
        this.sertificate = sertificate;
    }
    
    public String getEmplyeeNumber() {
        return employeeNumber;
    }
    
    public String getSertificate() {
        return sertificate;
    }
    
    /**
     * get the ooccupation.
     * 
     * return String with occupation
     */
    public String getOccupation() {
        return "pilot";
    }
}
