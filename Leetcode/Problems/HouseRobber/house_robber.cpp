#include <iostream>
using namespace std;
int rob(vector<int> nums)
{
    vector<int> maximums(nums.size(), 0);
    if (nums.size() == 1)
        return nums[0];
    maximums[0] = nums[0];
    maximums[1] = max(nums[0], nums[1]);
    for (int i = 2; i < nums.size(); i++)
    {
        maximums[i] = max(maximums[i - 1], maximums[i - 2] + nums[i]);
    }
    return maximums[nums.size() - 1];
}
int main()
{
    vector<int> nums = {2, 1, 1, 2};
    cout << rob(nums) << endl;
}