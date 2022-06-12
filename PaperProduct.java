/**
 * Stores details about a paper product in general.
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */

public class PaperProduct {
    public static final double COST_PER_GRAM = 0.025;
    private static int totalProductsToShip = 10;
    private final String name; //default: A4
    private final double weightOfUnitSheet;
    private int numberOfSheets;


    //constructors -----------------

    /**
     * Creates a paper product with the specified name, number of sheets, weight of unit sheet.
     * @param name the name of the product
     * @param numberOfSheets number of sheets in the product
     * @param weightOfUnitSheet weight of a piece of sheet
     */
    public PaperProduct(String name, int numberOfSheets, double weightOfUnitSheet) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "A4";
        }
        if (numberOfSheets >= 0) {
            this.numberOfSheets = numberOfSheets;
        } else {
            this.numberOfSheets = 500;
        }
        if (weightOfUnitSheet >= 0) {
            this.weightOfUnitSheet = weightOfUnitSheet;
        } else {
            this.weightOfUnitSheet = 0.25;
        }
    }

    /**
     * Creates a paper product with the specified name, number of sheets.
     * @param name the name of the product
     * @param numberOfSheets number of sheets in the product
     */
    public PaperProduct(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25);
    }
    /**
     * Creates a paper product with the specified name and the default values
     * for numberOfSheet and weightOfUnitSheet variables.
     * @param name the name of the product
     */
    public PaperProduct(String name) {
        this(name, 500, 0.25);
    }

    /**
     * A copy constructor that deep copies all instance varialbes of the old object to the new object.
     * @param paperproduct the paperproduct object
     */
    public PaperProduct(PaperProduct paperproduct) {
        this.name = new String(paperproduct.name);
        this.numberOfSheets = paperproduct.numberOfSheets;
        this.weightOfUnitSheet = paperproduct.weightOfUnitSheet;
    }

    //methods--------------------
    /**
     * Method that calculates the total weight of the product.
     * @return total weight of the Paper Product
     */
    public double totalWeight() {
        double sumWeight = numberOfSheets * weightOfUnitSheet;
        return sumWeight;
    }

    /**
     * Method that calculates and retunrs total cost of the Paper Product.
     * @return the calculated total cost of the Paper Product
     */
    public double totalCost() {
        double sumCost = numberOfSheets * weightOfUnitSheet * COST_PER_GRAM;
        return sumCost;
    }

    /**
     * Method that returns a String representing the Object.
      * @return a String representing the Object
     */
    public String paperString() {
        return String.format("%.2fg of %s for $%.2f", totalWeight(), getName(), totalCost());
    }

    /**
     * Method that returns a String updating the shipping status.
     * @param company the name of the company to ship
     * @return string according to condition of whether the product can be shipped or not
     */
    public String ship(String company) {
        if (totalProductsToShip != 0) {
            PaperProduct.totalProductsToShip = totalProductsToShip - 1;
            return String.format("Shipped %.2fg of %s for $%.2f to %s.",
                    totalWeight(), getName(), totalCost(), company);
        } else {
            return ("Cannot ship any items, Warehouse is empty!");
        }
    }

    //getters and setters-------------

    /**
     * Getter for name variable.
     * @return String representing name of the product
     * because this method has no return type,
     * an @param tag is not needed
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for numOfSheets variable.
     * @return int representing number of sheets in the product
     * because this method has no return type,
     * an @param tag is not needed
     */
    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    /**
     * Setter for numberOfSheets.
     * @param numberOfSheets int representing the number of sheets in the product.
     * because this method has no return type,
     * an @return tag is not needed
     */
    public void setNumberOfSheets(int numberOfSheets) {
        if (numberOfSheets >= 0) {
            this.numberOfSheets = numberOfSheets;
        } else {
            this.numberOfSheets = 500;
        }
    }

    /**
     * Getter for WeightOfUnitSheet.
     * @return double representing weight of a piece of paper/sheet
     * because this method has no return type,
     * an @param tag is not needed
     */
    public double getWeightOfUnitSheet() {
        return weightOfUnitSheet;
    }

    /**
     * Getter for getTotalProductsToShip.
     * @return int representing total products that the company can ship
     * because this method has no return type,
     * an @param tag is not needed
     */
    public static int getTotalProductsToShip() {
        return totalProductsToShip;
    }
}