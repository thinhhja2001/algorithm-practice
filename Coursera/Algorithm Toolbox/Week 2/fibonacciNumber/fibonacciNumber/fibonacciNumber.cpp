// fibonacciNumber.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
using namespace std;
unsigned long long fibonacci(unsigned long long n)
{
    vector<unsigned long long>list(n + 1);
    list[0] = 0;
    list[1] = 1;
    for (unsigned long long i = 2; i <= n; i++)
    {
        list[i] = list[i - 1] + list[i - 2];
    }
    return list[n];
}
int main()
{
    unsigned long long n;
    cin >> n;
    cout << fibonacci(n);
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
