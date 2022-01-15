// MajorityElement.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

int64_t majorityElement(vector<int64_t>arr)
{
	int64_t n = arr.size() / 2;
	unordered_map<int64_t, int64_t>umap;
	for (int64_t i = 0; i < arr.size(); i++)
	{
		if (umap.find(arr[i]) == umap.end())
		{
			umap.insert({ arr[i],1 });
		}
		else
		{
			umap[arr[i]]++;
		}
	}
	for (auto itr = umap.begin(); itr != umap.end(); itr++)
	{
		if (itr->second > n)
		{
			return 1;
		}
	}
	return 0;
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
	cout << majorityElement(arr) << endl;
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
