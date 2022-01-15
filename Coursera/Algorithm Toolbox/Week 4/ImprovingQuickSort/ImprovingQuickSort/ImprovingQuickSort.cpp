// ImprovingQuickSort.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
using namespace std;
int64_t partition(vector<int64_t>& arr, int64_t left, int64_t right, int64_t pivot)
{
	while (left <= right)
	{
		while (arr[left] < pivot) {
			left++;
		}
		while (arr[right] > pivot) {
			right--;
		}
		if (left <= right)
		{
			swap(arr[left], arr[right]);
			left++;
			right--;
		}
	}
	return left;
}
void quickSort(vector<int64_t>& arr, int64_t left, int64_t right)
{
	if (left >= right)
	{
		return;
	}
	int64_t pivot = arr[(left + right) / 2];
	int64_t index = partition(arr, left, right, pivot);
	quickSort(arr, left, index - 1);
	quickSort(arr, index, right);
}
void quickSort(vector<int64_t>& arr)
{
	quickSort(arr, 0, arr.size() - 1);
}
void print64_tVector(vector<int64_t>arr)
{
	for (int64_t i = 0; i < arr.size(); i++)
	{
		cout << arr[i] << " ";
	}
	cout << endl;
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
	quickSort(arr);
	print64_tVector(arr);
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
