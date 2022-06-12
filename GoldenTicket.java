/**
 * This file will store details about the Golden Tickets that customers can use with the Discounted Stock.
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */
public class GoldenTicket {
    private String catchphrase; // default: "Congrats!"
    private double discount;

    //constuctors---------------------------------
    /**
     * Creates a golden ticket with the specified catchphrase and discount.
     * @param catchphrase the catchphrase printed on the ticket
     * @param discount discount offered by the ticket, in percent, in the range (0, 25]
     */
    public GoldenTicket(String catchphrase, double discount) {
        if (catchphrase == null || catchphrase.equals("")) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
        if (discount > 0 && discount <= 25) {
            this.discount = discount;
        } else {
            this.discount = 15.0;
        }
    }
    //methods-------------------------------------

    /**
     * Method that returns a string that tells how much discount is included in the golden ticket.
     * @return a String representing the object
     */
    public String ticketString() {
        return String.format("Golden Ticket with a %.2f%% discount! %s", getDiscount(), getCatchphrase());
    }
    //getters and setters---------------------------------
    /**
     * Getter for the catchphrase variable.
     * @return String representing the catchphrase
     * because this method has no return type,
     * an @param tag is not needed
     */
    public String getCatchphrase() {
        return catchphrase;
    }
    /**
     * Getter for the discount variable.
     * @return double representing the discount of the golden ticket
     * because this method has no return type,
     * an @param tag is not needed
     */
    public double getDiscount() {
        return discount;
    }
    /**
     * Setter for the discount variable.
     * @param catchphrase representing the catchphrase for Golden ticket
     * because this method has no return type,
     * an @return tag is not needed
     */
    public void setCatchphrase(String catchphrase) {
        if (catchphrase == null || catchphrase.equals("")) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
    }
    /**
     * Setter for the discount variable.
     * @param discount representing discount of the golden ticket
     * because this method has no return type,
     * an @return tag is not needed
     */
    public void setDiscount(double discount) {
        if (discount > 0 && discount <= 25) {
            this.discount = discount;
        } else {
            this.discount = 15.0;
        }
    }
}