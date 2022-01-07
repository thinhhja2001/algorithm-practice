// MaximumSalary.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <sstream>
#include <cmath>
#include <math.h>
#include <algorithm>
using namespace std;
int64_t countDigit(int64_t n)
{
	int64_t count = 0;
	while (n != 0)
	{
		n = n / 10;
		count++;
	}
	return count;
}
int64_t compare(int64_t a, int64_t b)
{
	int64_t ab = a * pow(10, countDigit(b)) + b;
	int64_t ba = b * pow(10, countDigit(a)) + a;
	return ab > ba;
}
void print64_tVector(vector<int64_t>arr)
{
	for (int64_t i = 0; i < arr.size(); i++)
	{
		cout << arr[i] << " ";
	}
	cout << endl;
}

vector<int64_t> maxSalary(vector<int64_t>arr)
{
	sort(arr.begin(), arr.end(), compare);

	return arr;
}
int main()
{
	int64_t n;
	cin >> n;
	vector<int64_t>arr;
	for (int64_t i = 0; i < n; i++)
	{
		int64_t x;
		cin >> x;
		arr.push_back(x);
	}
	vector<int64_t>result = maxSalary(arr);
	for (int i = 0; i < result.size(); i++)
	{
		cout << result[i];
	}
	cout << endl;
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
