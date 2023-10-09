// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <math.h>
#include <unordered_map>
#include <unordered_set>
#include<stack>
#include <algorithm>
using namespace std;



class Solution {
public:
	static bool compareValue(pair<string, int>a, pair<string, int>b) {
		if (a.second == b.second) {
			return a.first < b.first;
		}
		return a.second > b.second;
	}

	vector<pair<string, int>> sortMap(unordered_map<string, int> m) {
		vector<pair<string, int>>arr;
		for (auto it : m) {
			arr.push_back(it);
		}
		sort(arr.begin(), arr.end(), compareValue);
		return arr;
	}
	vector<string>topKFrequent(vector<string>words, int k) {
		unordered_map<string, int>wordFrequency;
		for (string word : words) {
			if (wordFrequency[word] == NULL) {
				wordFrequency[word] = 1;
			}
			else {
				wordFrequency[word]++;
			}
		}

		vector<pair<string, int>>p = sortMap(wordFrequency);

		vector<string>res;
		for (int i = 0; i < k; i++) {
			res.push_back(p[i].first);
		}
		return res;
	}

};

int  main()
{
	vector<string>words = { "i","love","leetcode","i","love","coding" };
	int k = 2;
	Solution s;
	vector<string>result = s.topKFrequent(words, k);
	for (auto r : result) {
		cout << r << " ";
	}
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
