#ifndef PRODUCTMAIN_H
#define PRODUCTMAIN_H

//#include<bits/stdc++.h>
#include<iostream>
#include<string>
#include<vector>
using namespace std;

class ProductMain{
    private:
        string Name,ProductID,response_id;
        int Quantity;
        float Price;
    public:
        ProductMain(string response_id,string Name,string ProductID,int Quantity,float Price); //Constructor
        //Getters
        string getName();
        string getProductID();
        float getPrice();
        int getQuantity();
        string getresponse_id();
};
#endif

