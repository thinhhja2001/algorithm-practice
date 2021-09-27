#include <iostream>
#include <vector>
using namespace std;
int maxProfit(vector<int> &prices)
{
    int minPrice = INT_MAX;
    int globalProfit = 0;
    for (int i = 0; i < prices.size(); i++)
    {
        if (minPrice > prices[i])
        {
            minPrice = prices[i];
        }
        int currentProfit = prices[i] - minPrice;
        if (currentProfit > globalProfit)
        {
            globalProfit = currentProfit;
        }
    }
    return globalProfit;
}
int main()
{
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << maxProfit(prices);
}