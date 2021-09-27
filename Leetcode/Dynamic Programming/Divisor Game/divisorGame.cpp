#include <iostream>
#include <vector>
using namespace std;
bool divisorGame(int n)
{
    vector<bool> divisable(n + 1, false);
    for (int i = 0; i <= n; i++)
    {
        for (int j = 1; j < i; j++)
        {
            if (i % j == 0 && !divisable[i - j])
            {
                divisable[i] = true;
            }
        }
    }
    return divisable[n];
}
int main()
{
    int n;
    cin >> n;
    cout << boolalpha << divisorGame(n);
}