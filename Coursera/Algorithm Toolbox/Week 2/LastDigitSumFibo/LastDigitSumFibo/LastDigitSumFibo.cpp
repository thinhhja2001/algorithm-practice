// LastDigitSumFibo.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
using namespace std;


vector<unsigned long long> pisanoPeriod(unsigned long long m)
{
	vector<unsigned long long>period;
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
	return period;
}
unsigned long long lastDigitSumFibo(unsigned long long n)
{
	vector<unsigned long long>period = pisanoPeriod(10);
	unsigned long long periodSize = period.size() - 2;
	period.pop_back();
	period.pop_back();
	unsigned long long sumPisano = 0;
	for (unsigned long long i = 0; i < periodSize; i++)
	{
		sumPisano = (sumPisano + period[i]) % 10;
	}
	unsigned long long modulo = n % periodSize;
	unsigned long long sum = 0;
	for (unsigned long long i = 0; i < modulo; i++)
	{
		sum = (sum + period[i]) % 10;
	}
	return sum;
}
int main()
{
	unsigned long long n;
	cin >> n;
	cout << lastDigitSumFibo(n + 1) << endl;
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
