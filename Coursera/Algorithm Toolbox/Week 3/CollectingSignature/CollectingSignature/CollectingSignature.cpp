// CollectingSignature.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct TENANT {
	int64_t start;
	int64_t end;
};
bool compare(TENANT a, TENANT b)
{
	return b.end > a.end;
}
vector<int64_t> minVisit(vector<TENANT>tenants)
{
	sort(tenants.begin(), tenants.end(), compare);

	vector<bool>checkTenants(tenants.size(), true);
	vector<int64_t>visit;
	for (int64_t i = 0; i < tenants.size(); i++)
	{
		if (checkTenants[i])
		{
			int64_t currentEnd = tenants[i].end;
			for (int64_t j = i; j < tenants.size(); j++)
			{
				if (tenants[j].start <= currentEnd)
				{
					checkTenants[j] = false;
				}
			}
			visit.push_back(currentEnd);
		}
	}
	return visit;
}
int main()
{
		int64_t n;
		cin >> n;
		vector<TENANT>tenants;
		for (int64_t i = 0; i < n; i++)
		{
			TENANT tenant;
			int64_t start;
			cin >> start;
			tenant.start = start;
			int64_t end;
			cin >> end;
			tenant.end = end;
			tenants.push_back(tenant);
		}
		vector<int64_t>result = minVisit(tenants);
		cout << result.size() << endl;
		for (int64_t i = 0; i < result.size(); i++)
		{
			cout << result[i] << " ";
		}
		cout << endl;
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
