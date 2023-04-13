#ifndef DEMOPORTAL_H
#define DEMOPORTAL_H

//#include<bits/stdc++.h>
#include<fstream>
#include<sstream>
#include<iostream>
#include<vector>
#include<map>

using namespace std;

#include "../ProductMain.h"
#include "../Sort.h"
#include "../ecomm/Portal.h"

//DemoPortal
class DemoPortal: public Portal{
    private:
        string portalID;
        int reqid;
        map<int,string> cmd_id_map;  //map for command like (List,Buy etc) to reqid 
        map<int,string> sortorder_id_map; //map for price/Name to reqid
	public:
        DemoPortal(string);  //Constructor
        void processUserCommand(string command);
	
	    // checks for pending responses (in PortalToPlatform)
	    // Displays response
	    void checkResponse();
};

#endif