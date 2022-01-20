// MoneyChangeAgain.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>   
using namespace std;

int minChange(int sum, vector<int>moneys)
{
	vector<bool>sumAble(sum + 1, false);
	vector<int>minSum(sum + 1, 0);
	sumAble[0] = true;
	for (int i = 0; i < moneys.size(); i++)
	{
		if (moneys[i] <= sum)
		{
			sumAble[moneys[i]] = true;
			minSum[moneys[i]]++;
		}

	}
	for (int currentSum = 0; currentSum <= sum; currentSum++)
	{
		if (sumAble[currentSum])
		{
			for (int j = 0; j < moneys.size(); j++)
			{
				int nextSum = currentSum + moneys[j];
				if (nextSum <= sum)
				{
					sumAble[nextSum] = true;
					minSum[nextSum] = minSum[currentSum] + 1;

				}
			}
		}
	}
	for (int currentSum = 0; currentSum <= sum; currentSum++)
	{
		if (sumAble[currentSum])
		{
			for (int j = 0; j < moneys.size(); j++)
			{
				int nextSum = currentSum + moneys[j];
				if (nextSum <= sum)
				{
					sumAble[nextSum] = true;
					if (minSum[nextSum] > minSum[currentSum] + 1)
						minSum[nextSum] = minSum[currentSum] + 1;

				}
			}
		}
	}
	return minSum[sum];
}

int main()
{
	int sum;
	cin >> sum;
	vector<int>moneys = { 1,3,4 };
	cout << minChange(sum, moneys) << endl;
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
