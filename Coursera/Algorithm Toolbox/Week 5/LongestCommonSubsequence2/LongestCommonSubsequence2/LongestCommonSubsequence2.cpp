// LongestCommonSubsequence2.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector> 
#include <algorithm>
using namespace std;


int64_t lcd(vector<int64_t> s1, vector<int64_t> s2)
{
	int64_t maxColumn = s1.size() + 1;
	int64_t maxRow = s2.size() + 1;

	vector <vector<int64_t >> arr(maxColumn, vector<int64_t>(maxRow));

	for (int64_t i = 0; i < maxColumn; i++)
	{
		arr[i][0] = 0;
	}
	for (int64_t i = 0; i < maxRow; i++)
	{
		arr[0][i] = 0;
	}
	for (int64_t column = 1; column < maxColumn; column++)
	{
		for (int64_t row = 1; row < maxRow; row++)
		{
			if (s1[column - 1] == s2[row - 1])
			{
				arr[column][row] = arr[column - 1][row - 1] + 1;
			}
			else
			{
				arr[column][row] = max({ arr[column - 1][row],arr[column][row - 1] });
			}
		}
	}
	return arr[maxColumn - 1][maxRow - 1];
}

int main()
{
	int64_t n1;
	int64_t n2;
	cin >> n1;
	vector<int64_t>arr1;
	for (int64_t i = 0; i < n1; i++)
	{
		int64_t x;
		cin >> x;
		arr1.push_back(x);
	}
	cin >> n2;
	vector<int64_t>arr2;
	for (int64_t i = 0; i < n2; i++)
	{
		int64_t x;
		cin >> x;
		arr2.push_back(x);
	}
	cout << lcd(arr1, arr2) << endl;

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
