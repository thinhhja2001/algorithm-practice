// LongestCommonSubsequence3.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int64_t lcd2(vector<int64_t> s1, vector<int64_t> s2)
{
	int64_t column = s1.size() + 1;
	int64_t row = s2.size() + 1;
	vector<vector<int64_t>>arr(column, vector<int64_t>(row));
	for (int64_t i = 0; i < column; i++)
	{
		for (int64_t j = 0; j < row; j++)
		{
			if (i == 0 || j == 0)
			{
				arr[i][j] = 0;
			}
			else if (s1[i - 1] == s2[j - 1])
			{
				arr[i][j] = arr[i - 1][j - 1] + 1;
			}
			else if (s1[i - 1] != s2[j - 1])
			{
				arr[i][j] = max({ arr[i - 1][j],arr[i][j - 1] });
			}
		}
	}
	return arr[column - 1][row - 1];
}

int64_t lcd3(vector<int64_t>s1, vector<int64_t>s2, vector<int64_t>s3)
{
	int64_t column = s1.size() + 1;
	int64_t row = s2.size() + 1;
	int64_t zIndex = s3.size() + 1;
	vector < vector<vector<int64_t>>>arr(column, vector<vector<int64_t>>(row, vector<int64_t>(zIndex)));
	for (int64_t i = 0; i < column; i++)
	{
		for (int64_t j = 0; j < row; j++)
		{
			for (int64_t k = 0; k < zIndex; k++)
			{
				if (i == 0 || j == 0 || k == 0)
				{
					arr[i][j][k] = 0;
				}
				else if (s1[i - 1] == s2[j - 1] && s1[i - 1] == s3[k - 1])
				{
					arr[i][j][k] = arr[i - 1][j - 1][k - 1] + 1;
				}
				else
				{
					arr[i][j][k] = max({ arr[i - 1][j][k],arr[i][j - 1][k],arr[i][j][k - 1] });
				}
			}
		}
	}
	return arr[column - 1][row - 1][zIndex - 1];
}
int main()
{
	int64_t n1;
	cin >> n1;
	vector<int64_t>arr1;
	vector<int64_t>arr2;
	vector<int64_t>arr3;
	for (int64_t i = 0; i < n1; i++)
	{
		int64_t x;
		cin >> x;
		arr1.push_back(x);
	}
	int64_t n2;
	cin >> n2;
	for (int64_t i = 0; i < n2; i++)
	{
		int64_t x;
		cin >> x;
		arr2.push_back(x);
	}
	int64_t n3;
	cin >> n3;
	for (int64_t i = 0; i < n3; i++)
	{
		int64_t x;
		cin >> x;
		arr3.push_back(x);
	}
	cout << lcd3(arr1, arr2, arr3) << endl;

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
