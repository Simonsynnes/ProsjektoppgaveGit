package ticketreservationsystem;


/**
 * makes a passenger object. has a name and is loosely conected to the ticket.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Passenger {

    /**
     * Sets the lastName, surName and the emailAdress for the passenger.
     */

    private String lastName; // sets the lastName
    private String surName; // sets the surName
    private String emailAddress; // sets the emailAddress

    /**
     * Constructor sets the fields.
     *
     * @param lastName sets the lastName
     * @param surName sets the surName
     * @param emailAddress sets the emailAddress
     */
    public Passenger(String lastName, String surName, String emailAddress) {
        // initialise instance variables
        this.lastName = lastName;
        this.surName = surName;
        this.emailAddress = emailAddress;
    }

    /**
     * gets the String value of surName.
     *
     * @return the surName
     */
    public String getSurName() {
        // put your code here
        return "" + surName;
    }

    /**
     * gets the String value of lastName.
     *
     * @return the lastName
     */
    public String getLastName() {
        return "" + lastName;
    }

    /**
     * gets the String value of surName + lastName.
     *
     * @return the Fullname (surName + lastName)
     */
    public String getFullName() {
        return lastName + " " + surName;
    }

    /**
     * gets the String value of emailAddress.
     *
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * sets a new emailAdress.
     *
     * @param newEmail for the new eMail.
     */
    public void setEmailAdress(String newEmail) {
        emailAddress = newEmail;
    }
}
