#include <iostream>
#include <vector>
using namespace std;
int getMaximumGenerated(int n)
{
    if (n == 0)
        return n;
    vector<int> nums(n + 1, 0);
    nums[0] = 0;
    nums[1] = 1;
    for (int i = 0; i <= n; i++)
    {
        int even = 2 * i;
        int odd = 2 * i + 1;
        if (even <= n)
        {
            nums[even] = nums[i];
        }
        if (odd <= n)
        {
            nums[odd] = nums[i] + nums[i + 1];
        }
    }
    int max = nums[0];
    for (int num : nums)
    {
        if (num > max)
        {
            max = num;
        }
    }
    return max;
}
int main()
{
    int n;
    cin >> n;
    cout << getMaximumGenerated(n);
}