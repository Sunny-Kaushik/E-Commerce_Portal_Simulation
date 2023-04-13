//Implemented by Sunny Kaushik(IMT2021007)

package seller2;
import ecomm.*;

public class Product2 extends Product  {
    private String Name,ProductID;
    private int Quantity;
    private float Price;
    private Globals.Category category;
    public Product2(Globals.Category category,String Name,String ProductID,int Quantity,float Price)
    {
        this.Name=Name;
        this.ProductID=ProductID;
        this.Quantity=Quantity;
        this.Price=Price;
        this.category=category;
    }
    @Override
    public Globals.Category getCategory()
    {
        return this.category;
    }
    @Override
	public String getName()
    {
        return this.Name;
    }
    @Override
	public String getProductID()
    {
        return this.ProductID;
    }
    @Override
	public float getPrice()
    {
        return this.Price;
    }
    @Override
	public int getQuantity()
    {
        return this.Quantity;
    }
    public void decreaseQuantity(int reqQuantity)
    {
        this.Quantity=this.Quantity-reqQuantity;
    }
}
