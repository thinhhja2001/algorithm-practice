#include <iostream>
using namespace std;

int climbingStairs(int n)
{
    vector<int> wayCounter(n + 1, 0);
    wayCounter[0] = 1;
    wayCounter[1] = 1;
    for (int i = 2; i <= n; i++)
    {
        wayCounter[i] = wayCounter[i - 1] + wayCounter[i - 2];
    }
    return wayCounter[n];
}

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    cout << climbingStairs(n) << endl;
    return 0;
}
