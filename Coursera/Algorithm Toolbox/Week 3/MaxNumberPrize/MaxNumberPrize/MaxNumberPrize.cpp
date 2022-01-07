// MaxNumberPrize.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
using namespace std;
void print64_tVector(vector<int64_t>arr)
{
	for (int64_t i = 0; i < arr.size(); i++)
	{
		cout << arr[i] << " ";
	}
	cout << endl;
}
vector<int64_t> maxPrize(int64_t n)
{
	int64_t sum = 0;
	int64_t index = 1;
	int64_t count = 0;
	vector<int64_t>arr;
	while (sum + index <= n)
	{
		if (sum + index + index + 1 <= n)
		{
			sum += index;
			arr.push_back(index);
			index++;
		}
		else {
			arr.push_back(n - sum);
			break;
		}
	}
	return arr;
}

int main()
{
	int64_t n;
	cin >> n;
	vector<int64_t>result = maxPrize(n);
	cout << result.size() << endl;
	print64_tVector(result);

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
