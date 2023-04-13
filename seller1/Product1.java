//Implemented by Akash Perla(IMT2021530)

package seller1;
import ecomm.*;

public class Product1 extends Product  {
    private String Name,ProductID;
    private int Quantity;
    private float Price;
    private Globals.Category category;
    public Product1(Globals.Category category,String Name,String ProductID,int Quantity,float Price)
    {
        this.Name=Name;
        this.ProductID=ProductID;
        this.Quantity=Quantity;
        this.Price=Price;
        this.category=category;
    }
    //method to get the category
    @Override
    public Globals.Category getCategory()
    {
        return this.category;
    }
    //method to get the name
    @Override
	public String getName()
    {
        return this.Name;
    }
    //method to get product id 
    @Override
	public String getProductID()
    {
        return this.ProductID;
    }
    //method to get price
    @Override
	public float getPrice()
    {
        return this.Price;
    }
    //method to get quantity
    @Override
	public int getQuantity()
    {
        return this.Quantity;
    }
    //method to decrease quantity if that item is bought by the consumer
    public void decreaseQuantity(int reqQuantity)
    {
        this.Quantity=this.Quantity-reqQuantity;
    }
}
