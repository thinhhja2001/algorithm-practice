#include <iostream>
#include <vector>
using namespace std;
int stockMaximize(vector<long> stockPrice)
{
    int size = stockPrice.size();
    int maxProfit = 0;
    int currentMax = 0;
    for (int i = size - 1; i >= 0; i--)
    {
        if (stockPrice[i] >= currentMax)
        {
            currentMax = stockPrice[i];
        }
        maxProfit += currentMax - stockPrice[i];
    }
    return maxProfit;
}
int main()
{
    long testCase;
    cin >> testCase;
    for (long i = 0; i < testCase; i++)
    {
        long size;
        vector<long> stockPriceForEachDay;
        cin >> size;
        for (long j = 0; j < size; j++)
        {
            long x;
            cin >> x;
            stockPriceForEachDay.push_back(x);
        }
        cout << stockMaximize(stockPriceForEachDay) << endl;
    }
}