//#include <bits/stdc++.h>
#include<iostream>
#include<string>
#include<vector>
#include<fstream>
#include<sstream>
using namespace std;
#include "ProductMain.h"

//Constructor
ProductMain::ProductMain(string response_id,string Name,string ProductID,int Quantity,float Price)
{
    this->response_id=response_id;
    this->Name=Name;
    this->ProductID=ProductID;
    this->Quantity=Quantity;
    this->Price=Price;
}
//Getters
string ProductMain::getName()
{
    return this->Name;
}
string ProductMain::getProductID()
{
    return this->ProductID;
}
float ProductMain::getPrice()
{
    return this->Price;
}
int ProductMain::getQuantity()
{
    return this->Quantity;
}
string ProductMain::getresponse_id()
{
    return this->response_id;
}
