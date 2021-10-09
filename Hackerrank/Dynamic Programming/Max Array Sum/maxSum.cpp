#include <iostream>
#include <vector>
using namespace std;
int maxSubsetSum(vector<int> arr)
{
    int n = arr.size();
    if (n == 0)
        return 0;
    if (n == 1)
        return arr[0];
    arr[0] = max(0, arr[0]);
    arr[1] = max(arr[0], arr[1]);

    for (int i = 2; i < arr.size(); i++)
    {
        arr[i] = max(arr[i - 1], arr[i] + arr[i - 2]);
    }
    return arr[n - 1];
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