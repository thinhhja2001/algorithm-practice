#include <iostream>
#include <vector>
using namespace std;
int maxSubsetSum(vector<int> arr)
{
    int n = arr.size();
    if (n == 0)
        return 0;
    vector<int> maxAtIndex(n);
    maxAtIndex[0] = max(0, arr[0]);
    maxAtIndex[1] = max(maxAtIndex[0], arr[1]);
    for (int i = 2; i < arr.size(); i++)
    {
        maxAtIndex[i] = max(maxAtIndex[i - 1], maxAtIndex[i - 2] + arr[i]);
    }
    return maxAtIndex[n - 1];
}
int main()
{
    int n;
    cin >> n;
    vector<int> arr;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        arr.push_back(x);
    }
    cout << maxSubsetSum(arr) << endl;
}