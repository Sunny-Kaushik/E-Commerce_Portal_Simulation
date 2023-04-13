//Implemented by Akash Perla(IMT2021530)

package seller1;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Seller;
import ecomm.Product;
import java.util.ArrayList;
import java.util.Random;

public class Seller1 extends Seller {
    private ArrayList<Product1> prod_list= new ArrayList<Product1>(); //to store the products
    private Random rand = new Random(); //to create random price of product
    
	// id is passed in by the class that instantiates sub-type of seller
	public Seller1(String id) 
    {
		super(id);
        //Products
        Product1 b1= new Book(Globals.Category.Book,"Panchatantra","B01", 10, rand.nextFloat()*1000);
        Product1 b2= new Book(Globals.Category.Book,"Ramayana", "B02", 30, rand.nextFloat()*1000);
        Product1 b3= new Book(Globals.Category.Book,"Mahabharata","B03",15,rand.nextFloat()*1000);
        Product1 b4= new Book(Globals.Category.Book,"Arthashastra", "B04", 45, rand.nextFloat()*1000);
        Product1 b5= new Book(Globals.Category.Book, "Shakuntala", "B05", 20, rand.nextFloat()*1000);
        Product1 m1= new Mobile(Globals.Category.Mobile, "IPhone 12", "M01", 15, rand.nextFloat()*1000);
        Product1 m2= new Mobile(Globals.Category.Mobile,"Samsung Note 7", "M02",20, rand.nextFloat()*1000);
        Product1 m3= new Mobile(Globals.Category.Mobile,"Google Pixel 5", "M03", 6, rand.nextFloat()*1000);
        Product1 m4= new Mobile(Globals.Category.Mobile,"Jio Phone", "M04", 50, rand.nextFloat()*1000);

        //storing in the arraylist
        prod_list.add(b1);
        prod_list.add(b2);
        prod_list.add(b3);
        prod_list.add(b4);
        prod_list.add(b5);
        prod_list.add(m1);
        prod_list.add(m2);
        prod_list.add(m3);
        prod_list.add(m4);
	}
	
	// Platform it is being added to.
	// Should in turn add itself to the Platform (with addSeller)
	public void addPlatform(Platform thePlatform)
    {
        thePlatform.addSeller(this);
    }
	
	// Seller to return listing of Products of specified Category
	public ArrayList<Product> findProducts(Globals.Category whichOne)
    {
        //we iterate through the array list created earlier and find the one with required category and add it into a new arraylist
        ArrayList<Product> required_prod=new ArrayList<Product>();
        for(int i=0;i<prod_list.size();i++)
        {
            if(prod_list.get(i).getCategory()==whichOne)
            {
                required_prod.add(prod_list.get(i));
            }
        }
        return required_prod;
    }
	// User wants to buy specified quantity of productID
	// Return true if transaction succeeds, false otherwise. 
	// Transaction fails if incorrect productID or quantity exceeds available inventory
	public boolean buyProduct(String productID, int quantity)
    {
        for(int i=0;i<prod_list.size();i++)
        {
            if(prod_list.get(i).getProductID().equals(productID)&& prod_list.get(i).getQuantity()>= quantity)
            {
                prod_list.get(i).decreaseQuantity(quantity);
                return true;
            }
        }
        return false;
    }
	
}