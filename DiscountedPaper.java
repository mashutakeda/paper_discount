/**
 * This file will store details about the Discounted Paper stock in the warehouse. It is a child class of
 * PaperProduct.
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */
public class DiscountedPaper extends PaperProduct {
    private GoldenTicket ticket = null;
    private double discount;

    //constructors---------------------------------

    /**
     * Creates a discounted paper product with the specified name, number of sheets,
     * weight of unit sheet, discount, and ticket.
     * @param name the name of the product from PaperProduct
     * @param numberOfSheets number of sheets in the product from PaperProduct
     * @param weightOfUnitSheet weight of a piece of sheet from PaperProduct
     * @param discount discount of the paper product, in percent, in the range (0, 50]
     * @param ticket representing whether this product has a golden ticket attached to it.
     *               It has a default value of null.
     */
    public DiscountedPaper(String name, int numberOfSheets, double weightOfUnitSheet,
                           double discount, GoldenTicket ticket) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (discount > 0 && discount <= 50) {
            this.discount = discount;
        } else {
            this.discount = 15;
        }
        this.ticket = ticket;
    }
    /**
     * Creates a discounted paper product with the specified name and number of sheets.
     * @param name the name of the product from PaperProduct
     * @param numberOfSheets number of sheets in the product from PaperProduct
     */
    public DiscountedPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets, 0.25);
        this.discount = 15;
        this.ticket = null;
    }
    /**
     * Creates a discounted paper product with the specified name.
     * @param name the name of the product from PaperProduct
     */
    public DiscountedPaper(String name) {
        super(name, 500, 0.25);
        this.discount = 15;
        this.ticket = null;
    }

    /**
     * Creates a discounted paper product with deep copy of name, numOfSheets,
     * weightOfUnitSheet, discount, and ticket variables.
     * @param discountedpaper representing all instance variables of the old Object
     */
    public DiscountedPaper(DiscountedPaper discountedpaper) {
        super(discountedpaper);
        this.discount = discountedpaper.discount;
        this.ticket = new GoldenTicket(discountedpaper.ticket.getCatchphrase(),
                discountedpaper.ticket.getDiscount());
    }

    //methods-------------------------------------

    /**
     * Method that calculates the total cost after applying discount and golden ticket.
     * @return a double representing the total cost after applying discounts
     */
    public double discountedCost() {
        if (getTicket() != null) {
            double totalCost = totalCost() * (1 - this.ticket.getDiscount() / 100) * (1 - this.getDiscount() / 100);
            return totalCost;
        } else {
            double totalCost = totalCost() * (1 - this.getDiscount() / 100);
            return totalCost;

        }
    }

    /**
     * Method that returns a String that shows information about the product shipment.
     * @param company the name of the company to ship
     * @return a String that shows information about the product shipment.
     */
    public String shipDiscounted(String company) {
        return String.format(super.ship(company) + "The total cost after the discount is %.2f.", discountedCost());
    }

    /**
     * Method that returns a String to representing the discounting of this
     * product as an entry for the accounting department.
     * @return String reprenseint the discounting of the product as an entry for the accounting department
     */
    public String botherAccounting() {
        if (getTicket() != null) {
            return String.format("Discounted Paper Product:\nOriginal Cost: %.2f\nFinal Cost: %.2f\n"
                            + "Original Discount: %.2f%%\nGolden Ticket Discount: %.2f%%",
                    totalCost(), discountedCost(), this.getDiscount(), this.ticket.getDiscount());
        } else {
            return String.format("Discounted Paper Product:\nOriginal Cost: %.2f\nFinal Cost: %.2f\n"
                            + "Original Discount:%.2f%%\nGolden Ticket Discount: 0.00%%",
                    totalCost(), discountedCost(), this.getDiscount());
        }

    }
//
    //getters and setters------------------------------
    /**
     * Getter for the discount variable.
     * @return double representing the discount of the paper product
     * because this method has no return type,
     * an @param tag is not needed
     */
    public double getDiscount() {
        return discount;
    }
    /**
     * Setter for discount variable.
     * @param discount double representing discount of the paper product in percent
     * because this method has no return type,
     * an @return tag is not needed
     */
    public void setDiscount(double discount) {
        if (discount > 0 && discount <= 50) {
            this.discount = discount;
        } else {
            this.discount = 15;
        }
    }
    /**
     * Getter for the ticket variable.
     * @return Goldenticket representing whether this product has a golden ticket
     * because this method has no return type,
     * an @param tag is not needed
     */
    public GoldenTicket getTicket() {
        return ticket;
    }
    /**
     * Setter for ticket.
     * @param ticket GoldenTicket object representing whether there is a golden ticket attached.
     * because this method has no return type,
     * an @return tag is not needed
     */
    public void setTicket(GoldenTicket ticket) {
        this.ticket = ticket;
    }

}