#include <iostream>
#include <set>
#include <unordered_map>
using namespace std;

/// Time limit exceed with the test case in the main function, still figuring how to solve

void removeDuplicate(vector<vector<int>> &nums)
{
    vector<vector<int>> setOfNums;
    for (int i = 0; i < nums.size(); i++)
    {
        set<int> s(nums[i].begin(), nums[i].end());
        int count = 0;
        for (int j = 0; j < setOfNums.size(); j++)
        {
            set<int> son(setOfNums[j].begin(), setOfNums[j].end());
            if (s != son)
                count++;
        }
        if (count == setOfNums.size())
            setOfNums.push_back(nums[i]);
    }
    nums = setOfNums;
}

vector<vector<int>> twoSum(vector<int> nums, int target)
{
    unordered_map<int, int> m;
    vector<vector<int>> res;
    for (int i = 0; i < nums.size(); i++)
    {
        m.insert({nums[i], i});
    }

    for (int i = 0; i < nums.size(); i++)
    {
        int subtract = target - nums[i];
        if (m.find(subtract) != m.end())
        {
            if (i == m[subtract])
                continue;
            res.push_back({i, m[subtract]});
        }
    }
    return res;
}

vector<vector<int>> threeSum(vector<int> nums)
{
    vector<vector<int>> res;

    for (int i = 0; i < nums.size(); i++)
    {
        int target = nums[i] * -1;

        vector<vector<int>> sumOf2 = twoSum(nums, target);
        for (vector<int> sum : sumOf2)
        {
            if (sum[0] != i && sum[1] != i)
            {
                res.push_back({nums[sum[0]], nums[sum[1]], nums[i]});
            }
        }
    }
    removeDuplicate(res);
    return res;
}

void printVector(vector<int> arr)
{
    for (int element : arr)
    {
        cout << element << "\t";
    }
    cout << endl;
}

int main()
{
    vector<int> nums = {-11, -3, -6, 12, -15, -13, -7, -3, 13, -2, -10, 3, 12, -12, 6, -6, 12, 9, -2, -12, 14, 11, -4, 11, -8, 8, 0, -12, 4, -5, 10, 8, 7, 11, -3, 7, 5, -3, -11, 3, 11, -13, 14, 8, 12, 5, -12, 10, -8, -7, 5, -9, -11, -14, 9, -12, 1, -6, -8, -10, 4, 9, 6, -3, -3, -12, 11, 9, 1, 8, -10, -3, 2, -11, -10, -1, 1, -15, -6, 8, -7, 6, 6, -10, 7, 0, -7, -7, 9, -8, -9, -9, -14, 12, -5, -10, -15, -9, -15, -7, 6, -10, 5, -7, -14, 3, 8, 2, 3, 9, -12, 4, 1, 9, 1, -15, -13, 9, -14, 11, 9};

    vector<vector<int>> res = threeSum(nums);
    cout << "result\n";
    for (vector<int> e : res)
    {
        printVector(e);
    }
}
