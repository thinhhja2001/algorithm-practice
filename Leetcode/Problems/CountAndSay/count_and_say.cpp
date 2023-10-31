#include <iostream>
#include <unordered_map>
#include <queue>
using namespace std;

string say(string s)
{
    unordered_map<int, int> m;
    char currentChar = s[0];
    int currentCount = 0;
    queue<pair<int, char>> q;

    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] == currentChar)
        {
            currentCount++;
        }
        if (s[i] != currentChar)
        {
            q.push({currentCount, currentChar});
            currentChar = s[i];
            currentCount = 1;
        }
    }
    q.push({currentCount, currentChar});
    string a;
    while (!q.empty())
    {
        auto it = q.front();
        a += to_string(it.first) + it.second;
        q.pop();
    }
    return a;
}

string countAndSay(int n)
{
    vector<string> sayDigit(n + 1, "");
    sayDigit[1] = "1";
    for (int i = 2; i <= n; i++)
    {
        string s = say(sayDigit[i - 1]);
        sayDigit[i] = s;
    }
    return sayDigit[n];
}

int main(int argc, char const *argv[])
{
    // cout << say("1211") << endl;
    int n;
    cin >> n;
    cout << countAndSay(n) << endl;
}
