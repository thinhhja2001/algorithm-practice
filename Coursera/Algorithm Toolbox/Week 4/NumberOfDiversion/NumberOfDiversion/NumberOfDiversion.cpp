// NumberOfDiversion.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int64_t _mergeSort(vector<int64_t>& arr, vector<int64_t>& temp, int64_t left, int64_t right);
int64_t merge(vector<int64_t>& arr, vector<int64_t>& temp, int64_t left, int64_t mid,
	int64_t right);

/* This function sorts the
   input array and returns the
number of inversions in the array */
int64_t mergeSort(vector<int64_t>& arr, int64_t array_size)
{
	vector<int64_t>temp(array_size);
	return _mergeSort(arr, temp, 0, array_size - 1);
}

/* An auxiliary recursive function
  that sorts the input array and
returns the number of inversions in the array. */
int64_t _mergeSort(vector<int64_t>& arr, vector<int64_t>& temp, int64_t left, int64_t right)
{
	int64_t mid, inv_count = 0;
	if (right > left) {
		/* Divide the array int64_to two parts and
		call _mergeSortAndCountInv()
		for each of the parts */
		mid = (right + left) / 2;

		/* Inversion count will be sum of
		inversions in left-part, right-part
		and number of inversions in merging */
		inv_count += _mergeSort(arr, temp, left, mid);
		inv_count += _mergeSort(arr, temp, mid + 1, right);

		/*Merge the two parts*/
		//inv_count += merge(arr, temp, left, mid + 1, right);
		inv_count += merge(arr, temp, left, mid + 1, right);
	}
	return inv_count;
}

/* This funt merges two sorted arrays
and returns inversion count in the arrays.*/
int64_t merge(vector<int64_t>& arr, vector<int64_t>& temp, int64_t left, int64_t mid,
	int64_t right)
{
	int64_t i, j, k;
	int64_t inv_count = 0;

	i = left; /* i is index for left subarray*/
	j = mid; /* j is index for right subarray*/
	k = left; /* k is index for resultant merged subarray*/
	while ((i <= mid - 1) && (j <= right)) {
		if (arr[i] <= arr[j]) {
			temp[k++] = arr[i++];
		}
		else {
			temp[k++] = arr[j++];

			/* this is tricky -- see above
			explanation/diagram for merge()*/
			inv_count = inv_count + (mid - i);
		}
	}

	/* Copy the remaining elements of left subarray
(if there are any) to temp*/
	while (i <= mid - 1)
		temp[k++] = arr[i++];

	/* Copy the remaining elements of right subarray
	   (if there are any) to temp*/
	while (j <= right)
		temp[k++] = arr[j++];

	/*Copy back the merged elements to original array*/
	for (i = left; i <= right; i++)
		arr[i] = temp[i];

	return inv_count;
}

// Driver code
int main()
{
	vector<int64_t>arr;
	int64_t n;
	cin >> n;
	for (int64_t i = 0; i < n; i++)
	{
		int64_t x;
		cin >> x;
		arr.push_back(x);
	}
	int64_t ans = mergeSort(arr, n);
	cout << ans;
	return 0;
}

// This is code is contributed by rathbhupendra
