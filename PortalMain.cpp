// #include<bits/stdc++.h>
#include<iostream>
#include<string>
#include<vector>
#include<fstream>
#include<sstream>
using namespace std;
#include "demo/DemoPortal.h"

int main()
{
    srand(time(0));
    int x=(rand()%(rand()+rand()-1))%1000;
    string str="MyPortal-"+to_string(x);
    DemoPortal portal1(str); // creating a new portal
    string cmd;
    while(true)
    {
        getline(cin, cmd); //taking input form user
        if(cmd=="End")
            break;
        if(cmd=="Check")
        {
            portal1.checkResponse();
        }
        else
        {
            portal1.processUserCommand(cmd);
        }
    }
}