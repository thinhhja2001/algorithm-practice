// CarFuelling.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include <iostream>
#include <vector>
using namespace std;

int minFuelling(vector<int>arr, int car, int distance)
{
	int countRefil = 0;
	int nextRefil = car;
	int currentStation = 0;

	for (currentStation; currentStation < arr.size(); currentStation++)
	{
		if (arr[currentStation] > nextRefil)
		{
			return -1;
		}
		if (arr[currentStation] <= nextRefil)
		{
			while (currentStation + 1 < arr.size() && arr[currentStation + 1] <= nextRefil)
			{
				currentStation++;
			}
			if (nextRefil >= distance)
			{
				return countRefil;
			}
			else
			{
				countRefil++;
				nextRefil = arr[currentStation] + car;
			}
		}
	}
	if (nextRefil >= distance)
	{
		return countRefil;
	}
	return -1;
}

int main()
{
	int distance;
	int car;
	int n;
	vector<int>arr;
	cin >> distance >> car >> n;
	for (int i = 0; i < n; i++)
	{
		int x;
		cin >> x;
		arr.push_back(x);
	}
	cout << minFuelling(arr, car, distance) << endl;
}
