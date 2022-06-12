/**
 * This file will store details about the Photo Paper stock in the warehouse. It is a child class of PaperProduct.
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */
public class PhotoPaper extends PaperProduct {
    private double glossiness;

    //constructors ---------------
    /**
     * Creates a photo paper product with specified name, numberOfSheet, weightOfUnitSheet, and glossiness variables.
     * @param name the name of the product from PaperProduct
     * @param numberOfSheets number of sheets in the product from PaperProduct
     * @param weightOfUnitSheet weight of a piece of sheet from PaperProduct
     * @param glossiness a double representing the glossiness of the paper product in the range [0, 100].
     */
    public PhotoPaper(String name, int numberOfSheets, double weightOfUnitSheet, double glossiness) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (glossiness >= 0 && glossiness <= 100) {
            this.glossiness = glossiness;
        } else {
            this.glossiness = 70;
        }
    }
    //2.
    /**
     * Creates a photo paper product with specified name and numberOfSheet variables.
     * @param name the name of the product from PaperProduct
     * @param numberOfSheets number of sheets in the product from PaperProduct
     */
    public PhotoPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets, 0.25);
        this.glossiness = 70;
    }
    /**
     * Creates a photo paper product with specified name.
     * @param name the name of the product from PaperProduct
     */
    public PhotoPaper(String name) {
        super(name, 500, 0.25);
        this.glossiness = 70;
    }
    /**
     * Creates a photo paper product with deep copies of old variables to new variables.
     * @param photopaper representing the instance variables of the old object
     */
    public PhotoPaper(PhotoPaper photopaper) {
        super(photopaper);
        this.glossiness = photopaper.glossiness;
    }

    //methods----------------------------------

    /**
     * Method that returns a String representing the glosiness, weight, name, and total cost of a product.
     * @return String representing representing the glosiness, weight, name, and total cost of a product
     */
    public String photoString() {
        return String.format("%.2f glossy and %.2fg of %s for $%.2f",
                getGlossiness(), totalWeight(), getName(), totalCost());
    }

    /**
     * Method that returns a String updating photo paper after shipment.
     * @param company Name of the company that ships the product
     * @return a String updating photo paper after shipment
     */
    public String shipPhoto(String company) {
        return (String.format("Paper is %.2f%% glossy.", getGlossiness()) + super.ship(company));
    }
//
    //getters and setters
    /**
     * Getter for the glossiness variable.
     * @return double representing the glossiness of photo paper
     * because this method has no return type,
     * an @param tag is not needed
     */
    public double getGlossiness() {
        return glossiness;
    }

    /**
     * Setter for glossiness variable.
     * @param glossiness double representing the glossiness of photo paper
     * because this method has no return type,
     * an @return tag is not needed
     */
    public void setGlossiness(double glossiness) {
        if (glossiness >= 0 && glossiness <= 100) {
            this.glossiness = glossiness;
        } else {
            this.glossiness = 70;
        }
    }
}