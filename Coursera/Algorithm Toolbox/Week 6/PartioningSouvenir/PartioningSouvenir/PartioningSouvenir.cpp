// PartioningSouvenir.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int maxGold(int capacity, vector<int>weights)
{
	weights.insert(weights.begin(), 0);
	int maxColumn = weights.size();
	int maxRow = capacity + 1;
	vector<vector<int>>arr(maxColumn, vector<int>(maxRow));
	for (int i = 0; i < maxColumn; i++)
	{
		int value = weights[i];
		for (int j = 0; j < maxRow; j++)
		{
			if (i == 0 || j == 0)
			{
				arr[i][j] = 0;
			}
			else if (weights[i] <= j)
			{
				arr[i][j] = max({ arr[i - 1][j],arr[i - 1][j - weights[i]] + weights[i] });
			}
			else
			{
				arr[i][j] = arr[i - 1][j];
			}
		}
	}
	return arr[maxColumn - 1][maxRow - 1];
}
bool isParseAble(vector<int>items)
{
	int sum = 0;
	for (int i = 0; i < items.size(); i++)
	{
		sum += items[i];
	}
	if (sum % 3 == 0)
	{
		if (maxGold(sum / 3, items) == sum / 3)
		{
			return true;
		}
		return false;
	}
	return false;
}
int main()
{
	int n;
	vector<int>items;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int x;
		cin >> x;
		items.push_back(x);
	}
	cout << isParseAble(items) << endl;
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
