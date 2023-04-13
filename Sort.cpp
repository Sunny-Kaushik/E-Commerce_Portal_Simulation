//#include <bits/stdc++.h>
#include<iostream>
#include<string>
#include<vector>
using namespace std;
#include "Sort.h"

bool Sort::compare_price(ProductMain p1,ProductMain p2)
{
    return p1.getPrice()<p2.getPrice(); //sorting in ascending order
}
bool Sort::compare_Name(ProductMain p1, ProductMain p2)
{
    return p1.getName()<p2.getName(); //sorting in ascending order
}
