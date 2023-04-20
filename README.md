# E-Commerce_Portal_Simulation
In this project, we will simulate an e-commerce site. This site consists of 3 sets of players: Platform, Sellers, Customers.
Sellers offer Products through the Platform, which are viewed by Customers, who may then decide to order some of the products.
Customers interact with the system using the Customer Portal. Sellers attach themselves to the platform, while the Portal is also connected to the platform. Thus all interactions between customers and sellers are through the platform.

The Portal allows customers to view the list of available product categories. For each category, they can ask for a listing of available products. On viewing the listing (which can be sorted as per their preference), they may choose to purchase one or more units of a given product. Once sold, the product is no longer available to others.

When a customer makes a request (either for listing products or buying products), the portal relays the request to the platform. The platform, in turn, sends the request to the relevant sellers, and sends their response back to the portal.

->Design approach

● Platform: Provides a way for sellers to attach themselves to the platform. Receives requests from the portal (see below), and passes those on to the registered sellers. Gets their responses, and sends the consolidated response to the portal.

● Seller: Maintain different categories of products, and different products within each category. A seller can decide which products to offer, and the price for each item. Price can change dynamically, from call to call. Seller also maintains the count of each product and can only sell that many of a given product. . Each seller also assigns a unique name for each product (for instance, it could be <seller name>-<product name>.
  
● Portal: Mimics the front-end of an application, though here it would be command line based. Users can enter specified commands, which are passed to the platform. On return, the portal sorts the list of products as per the preference of the user and displays them.
  
● Product: provides a common view of all products. You can query the object for its category, unique name, price, and number available.
  
->Program execution
  
Run the main of the Java and C++ implementations - one the Platform and the other the Portal - in different windows. The user types in requests in the Portal, and sees the responses shown back in the same window. At the back, the Portal writes out requests as text messages in the file PortalToPlatform.txt. Each request line has a unique id (say an integer). The platform, when writing back the response in PlatformToPortal.txt, adds this request ID to the response details.
  
The user can type any of the following commands:
  
● List Category SortOrder
  
  ○ shows list of products belonging to Category from all sellers who have that Category, sorted by SortOrder, which is one of Price or Name
  
  ○ For each line, it shows:
    Product name, productID, price, number available, and optionally other information. Note that all these values are decided by each seller for the products they offer. ProductID should be unique across all sellers and products.
  
● Buy productID numItems
  
  ○ wants to buy that many items of the specified productID. The seller should ideally reduce their availability count. Also, you cannot buy more items than were offered, Such attempts will not be successful.
  
● Check
  
  ○ Asks the portal to check if there is a response from the platform for an earlier request.
  
●  The above commands can be called in any order. For instance there could be multiple “Buy” commands after a “List” and without any “Check” in between.
  
  
  
->Run the program

To run the shopping portal system, follow these steps:

● Open a terminal and run "PlatformMain.java" to start the Java-based platform.
  
● Open another terminal and run "PortalMain.cpp" to launch the C++-based portal.
  
● If you need to run multiple portals simultaneously, open a new terminal and execute the "PortalMain.cpp" program again. This setup allows you to run the shopping portal system with the Java-based platform and multiple instances of the C++-based portal concurrently.


  
