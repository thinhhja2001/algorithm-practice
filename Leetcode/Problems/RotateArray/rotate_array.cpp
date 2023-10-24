#include <iostream>
#include <math.h>
using namespace std;
void rotate(vector<int> &nums, int k)
{
    int size = nums.size();
    int actualRotate = k % size;
    vector<int> rotated(size, 0);
    for (int i = 0; i < size; i++)
    {
        int index;
        if (i + actualRotate >= size)
        {
            index = i - size + actualRotate;
        }
        else
        {
            index = i + actualRotate;
        }
        if (rotated[index] != 0)
            continue;
        rotated[index] = nums[i];
    }
    nums = rotated;
}
int main()
{
    vector<int> nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate(nums, k);
    for (int num : nums)
    {
        cout << num << " ";
    }
}