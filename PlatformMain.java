import java.util.Scanner;

import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import seller1.*;
import seller2.*;
import seller3.*;

public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform();  // replace with appropriate derived class
		Scanner sc=new Scanner(System.in);
		
		//Three sellers		
		Seller s1 = new Seller1("Seller1"); 
		s1.addPlatform(pf);
		//pf.processRequests();

		Seller s2 = new Seller2("Seller2");
		s2.addPlatform(pf);
		
		Seller s3 = new Seller3("Seller3");
		s3.addPlatform(pf);
 		
		String input;
		while(true)
		{
			input=sc.nextLine();
			if(input.equals("Check"))  //to process the requests
			{
				pf.processRequests();
			}
		}
	}

}