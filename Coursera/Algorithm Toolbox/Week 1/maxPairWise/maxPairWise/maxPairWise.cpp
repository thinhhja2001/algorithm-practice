// maxPairWise.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
using namespace std;

int64_t maxPairWise(vector<int64_t>arr)
{
	int64_t max1 = -100000;
	int64_t max2 = -100000;
	int64_t index1 = 0;
	for (int64_t i = 0; i < arr.size(); i++)
	{
		if (arr[i] > max1)
		{
			max1 = arr[i];
			index1 = i;
		}
	}
	for (int64_t i = 0; i < arr.size(); i++)
	{
		if (i == index1)
		{
			continue;
		}
		if (arr[i] > max2)
		{
			max2 = arr[i];
		}
	}
	return max1 * max2;
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
	cout << maxPairWise(arr);
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
