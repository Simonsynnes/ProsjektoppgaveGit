package no.ntnu.ticketreservationsystem.enteties;


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
    private String firstName; // sets the surName
    private String emailAddress; // sets the emailAddress

    /**
     * Constructor sets the fields.
     *
     * @param lastName sets the lastName
     * @param firstName sets the surName
     * @param emailAddress sets the emailAddress
     */
    public Passenger(String firstName, String lastName, String emailAddress) throws EmailFormatException {
        // initialise instance variables
        this.lastName = lastName;
        this.firstName = firstName;
        setEmailAddress(emailAddress);
    }

    /**
     * gets the String value of surName.
     *
     * @return the surName
     */
    public String getFirstName() {
        // put your code here
        return "" + firstName;
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
        return firstName + " " + lastName;
    }

    /**
     * gets the String value of emailAddress.
     *
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public String getEmplyeeNumber() {
        return null;
    }

    /**
     * sets a new emailAdress.
     *
     * @param newEmail for the new eMail.
     * @throws no.ntnu.ticketreservationsystem.enteties.EmailFormatException
     */
    public void setEmailAddress(String newEmail) throws EmailFormatException {
        if(newEmail.contains("@"))
        {
            emailAddress = newEmail;
        }
        else
        {
            throw new EmailFormatException();
        }
        emailAddress = newEmail;
    }
    
    /**
     * get the ooccupation.
     * 
     * return String with occupation
     */
    public String getOccupation() {
        return "passenger";
    }
}
