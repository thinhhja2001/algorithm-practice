#include <iostream>
#include <vector>
using namespace std;

int solve(vector<int> bags, int kid)
{
    int totalCandy = 0;
    for (int bag : bags)
    {
        totalCandy += bag;
    }
    int candyForEach = totalCandy / kid;
    return totalCandy - candyForEach * kid;
}

int main()
{
    int testCase;
    cin >> testCase;
    for (int i = 0; i < testCase; i++)
    {
        int bagCount;
        cin >> bagCount;
        vector<int> bags;
        int kid;
        cin >> kid;
        for (int i = 0; i < bagCount; i++)
        {
            int x;
            cin >> x;
            bags.push_back(x);
        }
        cout << "Case #" << i + 1 << ": " << solve(bags, kid) << endl;
    }
}