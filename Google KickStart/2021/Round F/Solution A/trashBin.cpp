#include <iostream>
#include <vector>

using namespace std;
long countWay(string trashStr)
{
    long size = trashStr.size();
    vector<long> left(size, 0);
    vector<long> right(size, 0);
    for (long i = 0; i < left.size(); i++)
    {
        if (trashStr[i] == '0')
        {
            long previous = i - 1;
            if (previous >= 0)
            {
                if (trashStr[previous] == '1')
                {
                    left[i]++;
                }
                if (trashStr[previous] == '0')
                {
                    left[i] += left[previous];
                    if (left[i] != 0)
                    {
                        left[i]++;
                    }
                }
            }
        }
    }
    for (long i = left.size() - 1; i >= 0; i--)
    {
        if (trashStr[i] == '0')
        {
            long after = i + 1;
            if (after < left.size())
            {
                if (trashStr[after] == '1')
                {
                    right[i]++;
                }
                if (trashStr[after] == '0')
                {
                    right[i] += right[after];
                    if (right[i] != 0)
                    {
                        right[i]++;
                    }
                }
            }
        }
    }
    long count = 0;
    for (long i = 0; i < trashStr.size(); i++)
    {
        if (trashStr[i] == '0')
        {
            if (left[i] != 0 && right[i] != 0)
            {
                count += min(left[i], right[i]);
            }
            else
            {
                count += max(left[i], right[i]);
            }
        }
    }
    return count;
}
int main()
{
    long testCase;
    cin >> testCase;
    for (long i = 0; i < testCase; i++)
    {
        long size;
        cin >> size;
        string s;
        cin >> s;
        cout << "Case #" << i + 1 << ": " << countWay(s) << endl;
    }
}