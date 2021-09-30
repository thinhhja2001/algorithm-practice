#include <iostream>
#include <vector>

using namespace std;

int minCostClimbingStairs(vector<int> &cost)
{
    int size = cost.size();
    vector<int> minCost(size + 1, 0);
    minCost[0] = cost[0];
    minCost[1] = cost[1];
    for (int i = 2; i < size; i++)
    {
        minCost[i] = cost[i] + min(minCost[i - 1], minCost[i - 2]);
    }
    return min(minCost[size - 1], minCost[size - 2]);
}
int main()
{
    vector<int> cost;
    int size;
    cin >> size;
    for (int i = 0; i < size; i++)
    {
        int x;
        cin >> x;
        cost.push_back(x);
    }
    cout << minCostClimbingStairs(cost);
}