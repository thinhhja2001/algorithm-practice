
// MaximumLoot.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include<iostream>
#include<vector>
#include<algorithm>
#include <iomanip>
using namespace std;

typedef struct item {
	double value;
	double weight;
} ITEM;

bool compare(ITEM a, ITEM b)
{
	double vw1 = a.value / a.weight;
	double vw2 = b.value / b.weight;
	return vw1 > vw2;
}
double maximumLoot(double capacity, vector<ITEM>items)
{
	sort(items.begin(), items.end(), compare);
	double sum = 0;
	double i = 0;

	while (capacity > 0)
	{
		if (i >= items.size())
		{
			break;
		}
		double vw = items[i].value * 1.0 / items[i].weight;
		if (capacity - items[i].weight >= 0)
		{
			sum += vw * items[i].weight;
			capacity -= items[i].weight;
			i++;
		}
		else
		{
			sum += vw * capacity;
			break;
		}
	}
	return sum;
}
int main()
{
	double n;
	cin >> n;
	double capacity;
	cin >> capacity;
	vector<ITEM>items;
	for (double i = 0; i < n; i++)
	{
		ITEM item;
		double value;
		cin >> value;
		double weight;
		cin >> weight;
		item.value = value;
		item.weight = weight;
		items.push_back(item);
	}
	cout << fixed << setprecision(9) << maximumLoot(capacity, items) << endl;
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
