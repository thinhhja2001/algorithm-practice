#include <iostream>
#include <math.h>
#include <vector>
#include <unordered_map>
#include <bits/stdc++.h>
using namespace std;
bool isLShaped(int x, int y)
{
    if (x == 0 || y == 0)
        return false;
    if (x * 2 == y || y * 2 == x)
        return true;
    return false;
}
int LShapedPlot(vector<vector<int>> grid)
{
    int R = grid.size();
    int C = grid.at(0).size();
    vector<vector<int>> top(R + 1, vector<int>(C + 1, 0));
    vector<vector<int>> left(R + 1, vector<int>(C + 1, 0));
    vector<vector<int>> bottom(R + 1, vector<int>(C + 1, 0));
    vector<vector<int>> right(R + 1, vector<int>(C + 1, 0));
    int count = 0;
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if (grid[i][j] == 0)
                continue;
            else
            {
                top[i][j] = 1;
                left[i][j] = 1;
                if (i > 0)
                {
                    top[i][j] += top[i - 1][j];
                }
                if (j > 0)
                {
                    left[i][j] += left[i][j - 1];
                }
            }
        }
    }
    for (int i = R - 1; i >= 0; i--)
    {
        for (int j = C - 1; j >= 0; j--)
        {
            if (grid[i][j] == 0)
                continue;
            else
            {
                bottom[i][j] = 1;
                right[i][j] = 1;
                if (i + 1 < R)
                {
                    bottom[i][j] += bottom[i + 1][j];
                }
                if (j + 1 < C)
                {
                    right[i][j] += right[i][j + 1];
                }
            }
        }
    }
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if (grid[i][j] == 0)
                continue;
            else
            {
                if (top[i][j] > 1 && left[i][j] > 1)
                {
                    count += min(top[i][j], left[i][j] / 2) - 1;
                    count += min(top[i][j] / 2, left[i][j]) - 1;
                }
                if (top[i][j] > 1 && right[i][j] > 1)
                {
                    count += min(top[i][j], right[i][j] / 2) - 1;
                    count += min(top[i][j] / 2, right[i][j]) - 1;
                }
                if (bottom[i][j] > 1 && left[i][j] > 1)
                {
                    count += min(bottom[i][j], left[i][j] / 2) - 1;
                    count += min(bottom[i][j] / 2, left[i][j]) - 1;
                }
                if (bottom[i][j] > 1 && right[i][j] > 1)
                {
                    count += min(bottom[i][j], right[i][j] / 2) - 1;
                    count += min(bottom[i][j] / 2, right[i][j]) - 1;
                }
            }
        }
    }
    return count;
}
int main()
{
    int testCase;
    cin >> testCase;
    for (int i = 1; i <= testCase; i++)
    {
        int R;
        int C;
        cin >> R;
        cin >> C;
        vector<vector<int>> grid(R, vector<int>(C, 0));
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                int x;
                cin >> x;
                grid[i][j] = x;
            }
        }
        cout << "Case #" << i << ": " << LShapedPlot(grid) << endl;
    }
}
