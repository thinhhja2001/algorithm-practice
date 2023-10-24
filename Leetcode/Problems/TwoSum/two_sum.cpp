#include <iostream>
#include <unordered_map>
using namespace std;
vector<int> twoSum(vector<int> &nums, int target)
{
    unordered_map<int, int> m;
    for (int i = 0; i < nums.size(); i++)
    {
        m.insert({nums[i], i});
    }
    for (int i = 0; i < nums.size(); i++)
    {
        int sub = target - nums[i];
        if (m.find(sub) != m.end())
        {
            int value = m[sub];
            if (i == value)
                continue;
            return {i, value};
        }
    }
    return {};
}
int main()
{
    vector<int> nums = {3, 2, 4};
    int target = 6;
    vector<int> res = twoSum(nums, target);
    for (int re : res)
    {
        cout << re << " ";
    }
}