#include <iostream>
#include <vector>
using namespace std;

bool increasingTriplet(vector<int> &nums)
{
    int count = 1;
    for (int i = 1; i < nums.size(); i++)
    {
        if (nums[i] > nums[i - 1])
        {

            count++;
            if (count >= 3)
                return true;
        }
        else
        {
            count = 1;
        }
    }
    return false;
}

int main(int argc, char const *argv[])
{
    vector<int> nums = {2, 1, 5, 0, 4, 6};
    cout << boolalpha << increasingTriplet(nums);
}
