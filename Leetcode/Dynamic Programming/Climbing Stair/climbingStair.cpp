#include <iostream>
#include <vector>
using namespace std;
int countWay(int target, vector<int> step)
{
    vector<bool> canConstruct(target + 1, false);
    canConstruct[0] = true;
    vector<int> countWayAt(target + 1, 0);
    countWayAt[0] = 1;
    for (int i = 0; i <= countWayAt.size(); i++)
    {
        if (canConstruct[i])
        {
            for (int value : step)
            {
                int current = i + value;
                if (current <= target)
                {
                    canConstruct[current] = true;
                    countWayAt[current] += countWayAt[i];
                }
            }
        }
    }
    return countWayAt[target];
}
int main()
{
    int target;
    cin >> target;
    vector<int> step = {1, 2};
    cout << countWay(target, step);
}