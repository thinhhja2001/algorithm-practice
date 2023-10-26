#include <iostream>

using namespace std;

bool isNegativeArray(vector<int> nums)
{
    for (int num : nums)
    {
        if (num > 0)
            return false;
    }
    return true;
}

int maxValueInArray(vector<int> nums)
{
    int max = nums[0];
    for (int num : nums)
    {
        if (num > max)
            max = num;
    }
    return max;
}

int maxSubArray(vector<int> nums)
{
    if (isNegativeArray(nums))
        return maxValueInArray(nums);
    int maxSum = 0;
    int curSum = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        if (curSum + nums[i] < 0)
            curSum = 0;
        else
        {
            curSum += nums[i];
            maxSum = max(maxSum, curSum);
        }
    }
    return maxSum;
}

int main(int argc, char const *argv[])
{
    vector<int> nums = {-3, -4, -5, -6, 0};
    cout << maxSubArray(nums) << endl;
}
