#include <iostream>
using namespace std;

void moveZeroes(vector<int> &nums)
{

    int i = 0;
    for (i = 0; i < nums.size(); i++)
    {
        if (nums[i] == 0)
        {
            break;
        }
    }
    int nonZeroIndex = i;
    for (; nonZeroIndex < nums.size(); nonZeroIndex++)
    {
        if (nums[nonZeroIndex] != 0)
        {
            break;
        }
    }
    while (i < nums.size() && nonZeroIndex < nums.size())
    {
        if (nums[nonZeroIndex] == 0)
        {
            nonZeroIndex++;
            continue;
        }
        else
        {
            swap(nums[i], nums[nonZeroIndex]);
            i++;
        }
    }
}

int main()
{
    vector<int> nums = {0, 1, 0, 3, 12};
    moveZeroes(nums);
    for (int num : nums)
    {
        cout << num << " ";
    }
}