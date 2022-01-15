// BinarySearch.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector> 
using namespace std;
int64_t binarySearch(vector<int64_t>arr, int64_t low, int64_t hight, int64_t key)
{
	while (low <= hight)
	{
		int64_t mid = (low + hight) / 2;
		if (arr[mid] == key)
		{
			return mid;
		}
		if (arr[mid] > key)
		{
			hight = mid - 1;
		}
		if (arr[mid] < key)
		{
			low = mid + 1;
		}
	}
	return -1;
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
	vector<int64_t>key;
	int64_t key_size;
	cin >> key_size;
	for (int64_t i = 0; i < key_size; i++)
	{
		int64_t x;
		cin >> x;
		key.push_back(x);
	}
	for (int64_t i = 0; i < key.size(); i++)
	{
		cout << binarySearch(arr, 0, arr.size() - 1, key[i]) << " ";
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
