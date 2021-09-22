#include <iostream>
#include <vector>
using namespace std;
int unboundedKnapsack(int targetSum, vector<int> arr)
{
    vector<bool> boundAble(targetSum + 1, false);
    boundAble[0] = true;
    for (int i = 0; i <= targetSum; i++)
    {
        if (boundAble[i])
        {
            for (int value : arr)
            {
                int currentSum = i + value;
                if (currentSum <= targetSum)
                {
                    boundAble[currentSum] = true;
                }
            }
        }
    }
    int max = 0;
    for (int i = 0; i < boundAble.size(); i++)
    {
        if (boundAble[i])
        {
            max = i;
        }
    }
    return max;
}
int main()
{
    int testCase;
    cin >> testCase;
    for (int i = 0; i < testCase; i++)
    {
        int size;
        int target;
        vector<int> arr;
        cin >> size >> target;
        for (int i = 0; i < size; i++)
        {
            int x;
            cin >> x;
            arr.push_back(x);
        }
        cout << unboundedKnapsack(target, arr) << endl;
    }
}