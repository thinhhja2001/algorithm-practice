// EditDistance.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <algorithm> 
#include <vector>
using namespace std;

int editDistance(string s1, string s2)
{
	vector<vector<int>>dp(s2.length() + 1, vector<int>(s1.length() + 1));
	for (int i = 0; i < dp.size(); i++)
	{
		dp[i][0] = i;
	}
	for (int i = 0; i < dp[0].size(); i++)
	{
		dp[0][i] = i;
	}
	for (int row = 1; row < dp.size(); row++)
	{
		for (int column = 1; column < dp[0].size(); column++)
		{
			if (s1[column - 1] != s2[row - 1])
			{
				dp[row][column] = min({ dp[row - 1][column],dp[row][column - 1],dp[row - 1][column - 1] }) + 1;
			}
			if (s1[column - 1] == s2[row - 1])
			{
				dp[row][column] = dp[row - 1][column - 1];
			}
		}
	}
	return dp[dp.size() - 1][dp[0].size() - 1];
}

int main()
{
	string s1;
	string s2;
	cin >> s1 >> s2;
	cout << editDistance(s1, s2) << endl;
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
