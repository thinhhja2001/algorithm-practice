#include <iostream>
#include <vector>

using namespace std;
int tribonacci(int n)
{
    vector<int> numberOf(n + 1, 0);
    numberOf[0] = 0;
    numberOf[1] = 1;
    numberOf[2] = 1;
    for (int i = 3; i <= n; i++)
    {
        numberOf[i] = numberOf[i - 1] + numberOf[i - 2] + numberOf[i - 3];
    }
    return numberOf[n];
}
int main()
{
    int n;
    cin >> n;
    cout << tribonacci(n);
}