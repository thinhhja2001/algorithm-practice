// GCDEuclid.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
using namespace std;
long long GCDEuclid(long long a, long long b)
{
    if (b == 0)
        return a;
    return GCDEuclid(b, a % b);
}
int main()
{
    long long a;
    long long b;
    cin >> a >> b;
    cout << GCDEuclid(a, b);
}
// Gọi d = GCD(a,b), ta có
// Gọi c = a % b => d % c == 0
// Chứng minh:
// Khi c = a % b => a = b*q + c
// d = GCD(a,b) => a%d == 0 && b%d ==0
// => c%d == 0
// GCDEuclid(a,b) = if (b==0) then a
//                  else GCDEuclid(b, c)
//
// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
