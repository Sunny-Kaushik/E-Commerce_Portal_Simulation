//#include<bits/stdc++.h>
#include<iostream>
#include<string>
#include<vector>
#include<fstream>
#include<sstream>
#include<map>
#include "DemoPortal.h"
using namespace std;

DemoPortal::DemoPortal(string portalID) :Portal()
{
    this->portalID=portalID;
    reqid=0; //requestid starts from 0
}
void DemoPortal::processUserCommand(string command)
{
    reqid++;  //whenever there is a process user command, reqid is incremented by 1
    istringstream ss(command);
    string word; 
    vector<string>cmds;  //after the string command is split, its stored in cmds
	while(ss >> word)
	{
		// print the read word
      	cmds.push_back(word);
	}

    if(cmds[0]=="List")
    {
        cmd_id_map[reqid]=cmds[0];
        sortorder_id_map[reqid]=cmds[2];
        //writing to the file
        ofstream fout;
        fout.open("PortalToPlatform.txt",std::ios_base::app);
        fout<<portalID<<" "<<reqid<<" "+cmds[0]<<" "<<cmds[1]<<endl;
        fout.close();
    }
    if(cmds[0]=="Buy")  //check this 
    {
        cmd_id_map[reqid]=cmds[0];
        //writing to the file
        ofstream fout;
        fout.open("PortalToPlatform.txt",std::ios_base::app);
        fout<<portalID<<" "<<reqid<<" "+cmds[0]<<" "<<cmds[1]+" "+cmds[2]<<endl;
        fout.close();
    }
    if(cmds[0]=="Start")
    {
        cmd_id_map[reqid]=cmds[0];
        //writing to the file
        ofstream fout;
        fout.open("PortalToPlatform.txt",std::ios_base::app);
        fout<<portalID<<" "<<reqid<<" "+cmds[0]<<endl;
        fout.close();
    }

    // fileformat.txt portalid..req..... 
    // write in PortalToPlatform.txt in the same format as given.

}
void DemoPortal::checkResponse()
{
    map<int,vector<vector<string> > > output; //to print output
    //reading the file 
    ifstream fin;
    fin.open("PlatformToPortal.txt");
    string line;
    vector<string> line_recieved; //to store the text from file
    while(getline(fin, line))
    {
        line_recieved.push_back(line);
    }
    vector<ProductMain> product_list; //we will create a product object and store it here
    //std::cout<<line_recieved.size()<<endl;
    vector<string> append_it;
    for(int i=0;i<line_recieved.size();i++)
    {
        istringstream ss(line_recieved[i]);
        string word; // for storing each words
        vector<string>line_recieved_split;  //to store after splitting
	    while(ss >> word)
	    {
      	    line_recieved_split.push_back(word);
	    }
        if(line_recieved_split[0]==portalID)  //we should only process commands whose portalid matches with the portalid on which we are currently executing
        {
            //Buy
            if(cmd_id_map[stoi(line_recieved_split[1])]=="Buy")
            {
                vector<string>temp;
                temp.push_back(line_recieved[i]);
                output[stoi(line_recieved_split[1])].push_back(temp); // we store the required results to be printed in output map 
            }
            else if(cmd_id_map[stoi(line_recieved_split[1])]=="List")
            {
                //The below few lines are for reconstructing the book/mobile name after we split the line recieved from portal
                string str;
                for(int j=2;j<line_recieved_split.size()-3;j++)
                {
                    if(j!=line_recieved_split.size()-4)
                    {
                        str=str+line_recieved_split[j]+" ";
                    }
                    else
                    {
                        str=str+line_recieved_split[j];
                    }    
                }
                //we create a product object and add it into product_list vector
                ProductMain p1(line_recieved_split[1],str,line_recieved_split[line_recieved_split.size()-3],stoi(line_recieved_split[line_recieved_split.size()-1]),stof(line_recieved_split[line_recieved_split.size()-2]));
                product_list.push_back(p1);
            }
            //Start
            else if(cmd_id_map[stoi(line_recieved_split[1])]=="Start")
            {
                vector<string>temp1;
                temp1.push_back(line_recieved[i]);
                output[stoi(line_recieved_split[1])].push_back(temp1); // we store the required results to be printed in output map 
            }
        }
        else
        {
            append_it.push_back(line_recieved[i]);
        }
    }
    vector<ProductMain> prod_list_forsort;
    string prev_reqid; //this variable will store the reqid;
    //for the purpose of sorting
    for(int i=0;i<product_list.size();i++)
    {
        if(i==0)
        {
            prev_reqid=product_list[i].getresponse_id(); 
            prod_list_forsort.push_back(product_list[i]);
        }
        else if(i!=product_list.size()-1)
        {
            if(product_list[i].getresponse_id()==prev_reqid)
            {
                prod_list_forsort.push_back(product_list[i]);
            }
            else  //if in the vector, there are objects of different reqid, we must sort only the ones with samr reqid
            {
                if(sortorder_id_map[stoi(prev_reqid)]=="Price")
                {
                    std::sort(prod_list_forsort.begin(),prod_list_forsort.end(),Sort::compare_price);
                }
                if(sortorder_id_map[stoi(prev_reqid)]=="Name")
                {
                    std::sort(prod_list_forsort.begin(),prod_list_forsort.end(),Sort::compare_Name);
                }
                vector<string>temp3; //it is used for storing the objects in the sorted order
                for(int j=0;j<prod_list_forsort.size();j++)
                {
                    temp3.push_back((prod_list_forsort[j].getName()+" "+prod_list_forsort[j].getProductID()+" "+to_string(prod_list_forsort[j].getPrice())+" "+to_string(prod_list_forsort[j].getQuantity())));
                }
                output[stoi(prev_reqid)].push_back(temp3); //we will store the vector in the output map
                temp3.clear();
                prod_list_forsort.clear();
                prev_reqid=product_list[i].getresponse_id(); //update the prev req id, after sorting the objects with same reqid
                prod_list_forsort.push_back(product_list[i]); //after clearing old contents, we can use new contents
            }
        }
        else
        {
            prod_list_forsort.push_back(product_list[i]);
            if(sortorder_id_map[stoi(prev_reqid)]=="Price")
            {
                std::sort(prod_list_forsort.begin(),prod_list_forsort.end(),Sort::compare_price);
            }
            if(sortorder_id_map[stoi(prev_reqid)]=="Name")
            {
                std::sort(prod_list_forsort.begin(),prod_list_forsort.end(),Sort::compare_Name);
            }
            vector<string>temp4; //it is used for storing the objects in the sorted order
            for(int j=0;j<prod_list_forsort.size();j++)
            {
                temp4.push_back((prod_list_forsort[j].getName()+" "+prod_list_forsort[j].getProductID()+" "+to_string(prod_list_forsort[j].getPrice())+" "+to_string(prod_list_forsort[j].getQuantity())));
            }
            output[stoi(prev_reqid)].push_back(temp4);
            temp4.clear();
            prod_list_forsort.clear();
        }
    }
    fin.close();
    ofstream fout;
    fout.open("PlatformToPortal.txt");
    fout.close();

    //The below are done to ensure that only commands with same portalid are processed
    fout.open("PlatformToPortal.txt",std::ios_base::app);
    for(int x=0;x<append_it.size();x++)
    {
        fout<<append_it[x]<<endl;
    }
    fout.close();
    //for printing the output
    for(auto it: output)
    {
        for(auto itr: it.second)
        {
            for(auto itrz: itr)
            {
                 cout<<itrz<<endl;
            }
           cout<<endl;
        } 
    }
    cout<<endl;
    cmd_id_map.clear();
    sortorder_id_map.clear();
    output.clear();
    append_it.clear();
}

