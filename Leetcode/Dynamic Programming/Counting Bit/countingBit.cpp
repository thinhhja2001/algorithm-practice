#include <iostream>
#include <vector>
using namespace std;
int countBitInNumber(int n)
{
    int count = 0;
    while (n != 0)
    {
        int temp = n % 2;
        if (temp == 1)
        {
            count++;
        }
        n = n / 2;
    }
    return count;
}
vector<int> countBits(int n)
{
    vector<int> bitList;
    for (int i = 0; i <= n; i++)
    {
        int count = countBitInNumber(i);
        bitList.push_back(count);
    }
    return bitList;
}
int main()
{
    int n;
    cin >> n;
    vector<int> count1 = countBits(n);
    for (int count : count1)
    {
        cout << count << "\t";
    }
}