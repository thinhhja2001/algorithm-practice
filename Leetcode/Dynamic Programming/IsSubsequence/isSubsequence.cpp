#include <iostream>
using namespace std;
bool isSubsequence(string target, string originalString)
{
    int targetIndex = 0;
    int originalIndex = 0;
    for (int i = 0; i < originalString.size(); i++)
    {
        if (originalString[i] == target[targetIndex])
        {
            targetIndex++;
        }
    }
    return targetIndex == target.size() ? true : false;
}
int main()
{
    string target;
    string originalString;
    cin >> target >> originalString;
    cout << boolalpha << isSubsequence(target, originalString);
}