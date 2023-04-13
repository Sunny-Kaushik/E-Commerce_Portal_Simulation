//Implemented by Mogli Rohit Kumar(IMT2021007)

package seller3;
import ecomm.*;

public class Product3 extends Product{
    private String Name,ProductID;
    private float Price;
    private int Quantity;
    private Globals.Category category;

    //Constructor
    public Product3(Globals.Category category,String Name,String ProductID,int Quantity,float Price)
    {
        this.Name=Name;
        this.ProductID=ProductID;
        this.Price=Price;
        this.Quantity=Quantity;
        this.category=category;

    }
    //Getters
    public Globals.Category getCategory(){
        return this.category;
    }
	public String getName(){
        return this.Name;
    }
	public String getProductID(){
        return this.ProductID;
    }
	public float getPrice(){
        return this.Price;
    }
	public int getQuantity(){
        return this.Quantity;
    }
    //A function to decrease the quantity
    public void decrease_quantity(int quantity)
    {
        this.Quantity-=quantity;
    }
}

