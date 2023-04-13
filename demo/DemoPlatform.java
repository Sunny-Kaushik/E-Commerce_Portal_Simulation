package demo;

import java.io.*;
import java.util.*;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Seller;
import ecomm.Product;
import ecomm.Globals.Category;

public class DemoPlatform extends Platform {

	//Arraylist with stores all sellers
	ArrayList<Seller> Pfm=new ArrayList<Seller>();

	//addSeller add the seller object to the Arraylist
	@Override
	public boolean addSeller(Seller aSeller) {
		Pfm.add(aSeller);
		return true;
	}

	//ProcessRequests basically reading and writing the file 
	@Override
	public void processRequests() {
		try {
			//creating the reader file to read from portal to platform
			BufferedReader reader = new BufferedReader(new FileReader(Globals.toPlatform));
			//creating the writer file to write from platform to portal
			BufferedWriter writer = new BufferedWriter(new FileWriter(Globals.fromPlatform));

			String line;
			//iterate the line string 
			while((line = reader.readLine()) != null)
			{
				// splitting the line string and storing it in the string array s, to perform operations accordingly
				String[] s=line.split(" ");

				//if the command encountered is List
				if(s[2].equals("List"))
				{
					for(int i=0;i<Pfm.size();i++)
					{
						//if the category of products found is Book
						if(s[3].equals("Book"))
						{
							for(Product A : Pfm.get(i).findProducts(Category.Book))
							{
								//if the quantity required is equal to or lesser than the quantity available 
								if(A.getQuantity()>0)
								{
									//write in the file
									writer.write(s[0]+" "+s[1]+" "+A.getName()+" "+A.getProductID()+" "+A.getPrice()+" "+A.getQuantity()+"\n");
								}
							}
						}
						//if the product category captured is Mobile
						else if(s[3].equals("Mobile"))
						{
							for(Product A : Pfm.get(i).findProducts(Category.Mobile))
							{
								if(A.getQuantity()>0)
								{
									//writing in the file
									writer.write(s[0]+" "+s[1]+" "+A.getName()+" "+A.getProductID()+" "+A.getPrice()+" "+A.getQuantity()+"\n");
								}
							}
						}
					}
					
				}
				//if the command buy is detected
				else if(s[2].equals("Buy"))
				{
					for(int j=0;j<Pfm.size();j++)
					{
						for(Product A : Pfm.get(j).findProducts(Category.Book))
						{
							//using the productID to get the item
							if(A.getProductID().equals(s[3]))
							{
								if(Pfm.get(j).buyProduct(s[3],Integer.parseInt(s[4]))){
									writer.write(s[0]+" "+s[1]+" "+"Success"+"\n");
								}
								else{
									writer.write(s[0]+" "+s[1]+" "+"Failure"+"\n");
								}
							}
						}

						for(Product A: Pfm.get(j).findProducts(Category.Mobile))
						{
							//if the request for buying product is accepted
							if(A.getProductID().equals(s[3]))
							{
								if(Pfm.get(j).buyProduct(s[3],Integer.parseInt(s[4]))){
									writer.write(s[0]+" "+s[1]+" "+"Success"+"\n");
								}
								else{
									writer.write(s[0]+" "+s[1]+" "+"Failure"+"\n");
								}
							}
						}
					}
				}
				//if the command detected is Start
				else if(s[2].equals("Start"))
				{
					writer.write(s[0]+" "+s[1]+" ");
					for(Globals.Category C: Category.values())
					{	
						writer.write(C.toString()+" ");
					}
					writer.write("\n");
				}
			}
			reader.close();
			writer.close();

			//finally closing the file
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(Globals.toPlatform));
			writer2.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}