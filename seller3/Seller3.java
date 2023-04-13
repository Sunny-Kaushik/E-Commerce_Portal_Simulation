//Implemented by Mogli Rohit Kumar(IMT2021007)

package seller3;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import ecomm.*;
import ecomm.Seller;

public class Seller3 extends Seller{

    private ArrayList<Product3> P= new ArrayList<Product3>();
    private Random random_generator = new Random(); //to create a random price for the products

    public Seller3(String id) {
        super(id);
        Product3 m1 = new Mobile(Globals.Category.Mobile,"Apple 14 pro","S3-101",15,ThreadLocalRandom.current().nextInt(1000,1500)*random_generator.nextFloat());
        Product3 m2 = new Mobile(Globals.Category.Mobile,"Samsung Galaxy","S3-102",18, ThreadLocalRandom.current().nextInt(1000,1500)*random_generator.nextFloat());
        Product3 m3 = new Mobile(Globals.Category.Mobile,"Apple 14 pro max","S3-103",19,ThreadLocalRandom.current().nextInt(1000,1500)*random_generator.nextFloat()); 
        Product3 b1 = new Book(Globals.Category.Book,"Ramanujan","S3-104",5,ThreadLocalRandom.current().nextInt(1000,1500)*random_generator.nextFloat()); 
        Product3 b2 = new Book(Globals.Category.Book,"Aryabhatta","S3-105",6, ThreadLocalRandom.current().nextInt(1000,1500)*random_generator.nextFloat()); 
        Product3 b3 = new Book(Globals.Category.Book,"Pythagoras","S3-106",7, ThreadLocalRandom.current().nextInt(1000,1500)*random_generator.nextFloat()); 

        P.add(m1);
        P.add(m2);
        P.add(m3);
        P.add(b1);
        P.add(b2);
        P.add(b3);

    }
    //to add the seller to the platform
    public void addPlatform(Platform thePlatform){
        thePlatform.addSeller(this);
    }

    // Seller to return listing of Products of specified Category
    public ArrayList<Product> findProducts(Globals.Category whichOne){
        ArrayList<Product> ans=new ArrayList<Product>();
        for(int i=0;i<P.size();i++)
        {
            if(P.get(i).getCategory()==whichOne)
            {
                ans.add(P.get(i));
            }
        }
        return ans;
    }

    // User wants to buy specified quantity of productID
	// Return true if transaction succeeds, false otherwise. 
	// Transaction fails if incorrect productID or quantity exceeds available inventory
	public boolean buyProduct(String productID, int quantity){
        for(int j=0;j<P.size();j++)
        {
            if(P.get(j).getProductID().equals(productID))
            {
                if(P.get(j).getQuantity()>=quantity)
                {
                    P.get(j).decrease_quantity(quantity);
                    return true;
                }
            }
        }
        return false;
    }
}
