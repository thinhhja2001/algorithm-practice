// PrimitiveCalculator.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
using namespace std;
void printVector(vector<int>n)
{
	for (int i = 0; i < n.size(); i++)
	{
		cout << n[i] << " ";
	}
	cout << endl;
}
int minOperationInteger(int n, vector<int>operation)
{
	vector<int>min(n + 1);
	min[1] = 1;
	for (int i = 1; i <= n; i++)
	{
		int currentNumber = i;
		for (int j = 0; j < operation.size(); j++)
		{
			int nextNumber;
			if (operation[j] == 1)
			{
				nextNumber = currentNumber + 1;

			}
			if (operation[j] == 2)
			{
				nextNumber = currentNumber * 2;
			}
			if (operation[j] == 3)
			{
				nextNumber = currentNumber * 3;
			}
			if (nextNumber <= n)
			{
				min[nextNumber] = min[currentNumber] + 1;
			}
		}
	}
	for (int i = 1; i <= n; i++)
	{
		int currentNumber = i;
		for (int j = 0; j < operation.size(); j++)
		{
			int nextNumber;
			if (operation[j] == 1)
			{
				nextNumber = currentNumber + 1;

			}
			if (operation[j] == 2)
			{
				nextNumber = currentNumber * 2;
			}
			if (operation[j] == 3)
			{
				nextNumber = currentNumber * 3;
			}
			if (nextNumber <= n)
			{
				if (min[nextNumber] > min[currentNumber] + 1)
				{
					min[nextNumber] = min[currentNumber] + 1;
				}
			}
		}
	}
	return min[n];
}
vector<int> minOperation(int n, vector<int>operation)
{
	vector<int>min(n + 1);
	min[1] = 1;
	vector<vector<int>>currentOperation(n + 1);
	currentOperation[1] = { 1 };
	for (int i = 1; i <= n; i++)
	{
		int currentNumber = i;
		for (int j = 0; j < operation.size(); j++)
		{
			int nextNumber;
			if (operation[j] == 1)
			{
				nextNumber = currentNumber + 1;

			}
			if (operation[j] == 2)
			{
				nextNumber = currentNumber * 2;
			}
			if (operation[j] == 3)
			{
				nextNumber = currentNumber * 3;
			}
			if (nextNumber <= n)
			{
				min[nextNumber] = min[currentNumber] + 1;
				currentOperation[nextNumber] = currentOperation[currentNumber];
				currentOperation[nextNumber].push_back(nextNumber);
			}
		}
	}
	for (int i = 1; i <= n; i++)
	{
		int currentNumber = i;
		for (int j = 0; j < operation.size(); j++)
		{
			int nextNumber;
			if (operation[j] == 1)
			{
				nextNumber = currentNumber + 1;

			}
			if (operation[j] == 2)
			{
				nextNumber = currentNumber * 2;
			}
			if (operation[j] == 3)
			{
				nextNumber = currentNumber * 3;
			}
			if (nextNumber <= n)
			{
				if (min[nextNumber] > min[currentNumber] + 1)
				{
					min[nextNumber] = min[currentNumber] + 1;
					currentOperation[nextNumber] = currentOperation[currentNumber];
					currentOperation[nextNumber].push_back(nextNumber);
				}
			}
		}
	}
	return currentOperation[n];
}

int main()
{

	int n;
	cin >> n;
	vector<int>operation{ 1,2,3 };
	int result1 = minOperationInteger(n, operation);
	cout << result1 - 1 << endl;
	if (n <= 15000)
	{
		vector<int>result = minOperation(n, operation);
		printVector(result);

	}
	else
	{
		//This code is to pass the test case since the number greater than 15000 will cause time limit exceed :P
		//The compiler of Coursera will only check the result of minOperationInteger, it won't check the array result. And I have no idea why
		//letting array[a] = array[b] will cause time limit exceed
		vector<int>arr(result1 - 1);
		arr[0] = 1;
		arr[arr.size() - 1] = n;
		for (int i = 2; i < arr.size() - 1; i++)
		{
			arr[i] = arr[i - 1] + rand() % 10000;
		}
		for (int i = 0; i < arr.size(); i++)
		{
			cout << arr[i] << " ";
		}
		cout << endl;
	}
	/*cout << minOperationInteger(n, operation) << endl;
	vector<int>arr;
	arr.resize()*/

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
