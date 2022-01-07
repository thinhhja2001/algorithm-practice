// MaximumRevenue.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
void printVector(vector<int64_t>arr)
{
	for (int64_t i = 0; i < arr.size(); i++)
	{
		cout << arr[i] << " ";
	}
	cout << endl;
}
bool comparePositive(int64_t a, int64_t b)
{
	return a > b;
}
bool compareNegative(int64_t a, int64_t b)
{
	return a < b;
}
int64_t maxRevenue(vector<int64_t>a, vector<int64_t>b)
{
	vector<int64_t>a_postivie;
	vector<int64_t>a_negative;
	vector<int64_t>b_positive;
	vector<int64_t>b_negative;
	int64_t sum = 0;
	for (int64_t i = 0; i < a.size(); i++)
	{
		if (a[i] >= 0)
		{
			a_postivie.push_back(a[i]);
		}
		else
		{
			a_negative.push_back(a[i]);
		}
	}
	for (int64_t i = 0; i < b.size(); i++)
	{
		if (b[i] >= 0)
		{
			b_positive.push_back(b[i]);
		}
		else
		{
			b_negative.push_back(b[i]);
		}
	}
	sort(a_postivie.begin(), a_postivie.end(), comparePositive);
	sort(a_negative.begin(), a_negative.end(), compareNegative);
	sort(b_positive.begin(), b_positive.end(), comparePositive);
	sort(b_negative.begin(), b_negative.end(), compareNegative);
	int64_t positive_index = 0;
	int64_t negative_index = 0;
	int64_t max_positive = a_postivie.size() < b_positive.size() ? a_postivie.size() : b_positive.size();
	int64_t max_negative = a_negative.size() < b_negative.size() ? a_negative.size() : b_negative.size();
	for (positive_index; positive_index < max_positive; positive_index++)
	{
		sum = sum + (a_postivie[positive_index] * b_positive[positive_index]);
	}
	positive_index++;
	for (negative_index; negative_index < max_negative; negative_index++)
	{
		sum = sum + (a_negative[negative_index] * b_negative[negative_index]);
	}
	negative_index++;
	//cout << "positiveIndex =" << positive_index << endl;
	//cout << "negativeIndex = " << negative_index << endl;
	vector<int64_t>positiveLeft;
	vector<int64_t>negativeLeft;
	if (a_postivie.size() < b_positive.size())
	{
		for (positive_index; positive_index < b_positive.size(); positive_index++)
		{
			positiveLeft.push_back(b_positive[positive_index]);
		}
	}
	if (a_postivie.size() > b_positive.size())
	{
		for (positive_index; positive_index < a_postivie.size(); positive_index++)
		{
			positiveLeft.push_back(a_postivie[positive_index]);
		}
	}
	if (a_negative.size() < b_negative.size())
	{
		for (negative_index; negative_index < b_negative.size(); negative_index++)
		{
			negativeLeft.push_back(b_negative[negative_index]);
		}
	}
	if (a_negative.size() > b_negative.size())
	{
		for (negative_index; negative_index < a_negative.size(); negative_index++)
		{
			negativeLeft.push_back(a_negative[negative_index]);
		}
	}
	sort(positiveLeft.begin(), positiveLeft.end(), compareNegative);
	for (int64_t i = 0; i < positiveLeft.size(); i++)
	{
		sum = sum + (positiveLeft[i] * negativeLeft[i]);
	}
	//print64_tVector(a_postivie);
	//print64_tVector(a_negative);
	//print64_tVector(b_positive);
	//print64_tVector(b_negative);
	return sum;
}
int main()
{
	int64_t n;
	cin >> n;
	vector<int64_t>a;
	vector<int64_t>b;
	for (int64_t i = 0; i < n; i++)
	{
		int64_t x;
		cin >> x;
		a.push_back(x);
	}
	for (int64_t i = 0; i < n; i++)
	{
		int64_t x;
		cin >> x;
		b.push_back(x);
	}

	cout << maxRevenue(a, b) << endl;
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
