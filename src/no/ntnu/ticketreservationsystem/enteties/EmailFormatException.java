/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.ticketreservationsystem.enteties;

/**
 *
 * @author Olav
 */
public class EmailFormatException extends Exception {
    public EmailFormatException() {
        super("E-mail does not match the proper format.");
    }
}
