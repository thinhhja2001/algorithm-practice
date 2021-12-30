// FibonacciNumberAgain.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
using namespace std;

vector<unsigned long long>period;

unsigned long long pisanoPeriod(unsigned long long m)
{
	period.push_back(0);
	period.push_back(1);
	while (true)
	{
		unsigned long long x = (period[period.size() - 1] + period[period.size() - 2]) % m;
		period.push_back(x);
		if (period[period.size() - 1] == 1 && period[period.size() - 2] == 0)
		{
			break;
		}
	}
	return period.size() - 2;
}
unsigned long long fibonacciAgain(unsigned long long n, unsigned long long m)
{
	return(period[n % pisanoPeriod(m)]);
}
int main()
{
	unsigned long long n;
	unsigned long long m;
	cin >> n;
	cin >> m;
	cout << fibonacciAgain(n, m);

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
