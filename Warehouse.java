/**
 * This Java file is a driver. It contains and runs all the classes.
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */
public class Warehouse {
    /**
     * Main method that creates new objects and tests methods from
     * PaperProduct, GoldenTicket, DiscountedPaper, and PhotoPaper.
     * @param args data you pass into the method's parameters
     */
    public static void main(String[] args) {
        //PaperProducts
        PaperProduct a = new PaperProduct("A Paper", 30, 10.0);
        PaperProduct b = new PaperProduct("B Paper", 30);
        PaperProduct c = new PaperProduct("C Paper");
        PaperProduct abcd = new PaperProduct(a);

        System.out.println(a.totalWeight());
        System.out.println(a.totalCost());
        System.out.println(a.paperString());
        System.out.println(a.ship("Company Name"));
        System.out.println("Testing deep copy: " + (a == abcd));

        //DiscountedPaper
        DiscountedPaper d = new DiscountedPaper("D Paper", 30, 10.0, 50, null);
        DiscountedPaper e = new DiscountedPaper("E Paper", 30);
        DiscountedPaper f = new DiscountedPaper("F Paper");
        DiscountedPaper def = new DiscountedPaper("Deep Copy");

        System.out.println(d.discountedCost());
        System.out.println(d.shipDiscounted("Company Name"));
        System.out.println(d.botherAccounting());
        System.out.println(e.botherAccounting());
        System.out.println(f.botherAccounting());
        System.out.println(def.botherAccounting());

        //PhotoPaper
        PhotoPaper g = new PhotoPaper("G Paper", 30, 10.0, 70);
        PhotoPaper h = new PhotoPaper("H Paper", 30);
        PhotoPaper i = new PhotoPaper("I Paper");

        System.out.println(g.photoString());
        System.out.println(g.shipPhoto("Company Name"));

        //GoldenTicket
        GoldenTicket j = new GoldenTicket("Hey congradulations", 50.0);
        System.out.println(j.ticketString());
        System.out.println(j.getCatchphrase());
        System.out.println(j.getDiscount());

    }
}