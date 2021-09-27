#include <iostream>
#include <math.h>
#include <vector>
using namespace std;
string reverseString(string s)
{
    string reverseString;
    for (int i = s.size() - 1; i >= 0; i--)
    {
        reverseString += s[i];
    }
    return reverseString;
}
int kGoodnessString(string s, int k)
{
    int countGoodness = 0;
    string reverse = reverseString(s);
    for (int i = 0; i < s.size() / 2; i++)
    {
        if (s[i] != reverse[i])
        {
            countGoodness++;
        }
    }
    return abs(countGoodness - k);
}

int main()
{
    int testCase;
    cin >> testCase;
    for (int i = 0; i < testCase; i++)
    {
        int length;
        int goodness;
        string test;
        cin >> length;
        cin >> goodness;
        cin >> test;
        cout << "Case #" << i + 1 << ": " << kGoodnessString(test, goodness) << endl;
    }
}
