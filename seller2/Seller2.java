//Implemented by Sunny Kaushik(IMT2021007)

package seller2;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Seller;
import ecomm.Globals.Category;
import ecomm.Product;
import java.util.*;

public class Seller2 extends Seller 
{
    private ArrayList<Product2> product_list= new ArrayList<Product2>(); //to store the product objects
    private ArrayList<Product2> book_list=new ArrayList<Product2>();
    private ArrayList<Product2>mobile_list=new ArrayList<Product2>();
    private float min = 350.0f;
    private float max = 1000.0f;
    private Random r = new Random(); //to create a random price for the products
    
	public Seller2(String id) 
    {
        super(id);
        Product2 b1= new Book(Globals.Category.Book,"A guide to Probability and statistics by Bheem","S-01", 10, (min + r.nextFloat() * (max - min)));
        Product2 b2= new Book(Globals.Category.Book,"Modern Physics by Raju", "S-02", 30,  (min + r.nextFloat() * (max - min)));
        Product2 b3= new Book(Globals.Category.Book,"Biological Sciences by Chutki", "S-03", 30,  (min + r.nextFloat() * (max - min)));
        Product2 m1= new Mobile(Globals.Category.Mobile, "Dholakpur D11", "S-04", 15,  (min + r.nextFloat() * (max - min)));
        Product2 m2= new Mobile(Globals.Category.Mobile, "Fancy Apple-12", "S-05", 15,  (min + r.nextFloat() * (max - min)));
        Product2 m3= new Mobile(Globals.Category.Mobile, "Red Apple-14", "S-06", 15,  (min + r.nextFloat() * (max - min)));
        Product2 m4 = new Mobile(Globals.Category.Mobile, "Kirimada-K11", "S-07", 7, (min + r.nextFloat() * (max - min)));
        book_list.add(b1);
        book_list.add(b2);
        mobile_list.add(m1);
        mobile_list.add(m2);
        mobile_list.add(m3);
        mobile_list.add(m4);
        book_list.add(b3);
        
        product_list.add(b1);
        product_list.add(b2);
        product_list.add(m1);
        product_list.add(m2);
        product_list.add(m3);
        product_list.add(m4);
        product_list.add(b3);

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
        ArrayList<Product> required_prod=new ArrayList<Product>();
        if(whichOne==Category.Mobile)
        {
            for(int i=0;i<mobile_list.size();i++)
            {
                required_prod.add(mobile_list.get(i));
            }
            return required_prod;
        }
        else if(whichOne==Category.Book)
        {
            for(int i=0;i<book_list.size();i++)
            {
                required_prod.add(book_list.get(i));
            }
            return required_prod;
        }
        else
        {
            return required_prod;
        }
    }
	// User wants to buy specified quantity of productID
	// Return true if transaction succeeds, false otherwise. 
	// Transaction fails if incorrect productID or quantity exceeds available inventory
	public boolean buyProduct(String productID, int quantity)
    {
        for(int i=0;i<product_list.size();i++)
        {
            if(product_list.get(i).getProductID().equals(productID))
            {
                if(product_list.get(i).getQuantity()>= quantity)
                {
                    product_list.get(i).decreaseQuantity(quantity);
                    return true;
                }
            }
        }
        return false;
    }
}