#include <iostream>
#include <vector>
using namespace std;
vector<vector<int>> generate(int numRows)
{
    if (numRows == 1)
    {
        return {{1}};
    }
    vector<vector<int>> pascalTriangle(numRows);
    pascalTriangle[0] = {1};
    pascalTriangle[1] = {1, 1};
    for (int i = 2; i < numRows; i++)
    {
        pascalTriangle.at(i).resize(i + 1);
        pascalTriangle.at(i).at(0) = 1;
        pascalTriangle.at(i).at(i) = 1;
    }
    for (int i = 2; i < numRows; i++)
    {
        for (int j = 1; j < i; j++)
        {
            pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
        }
    }
    return pascalTriangle;
}
int main()
{
    int numsRow;
    cin >> numsRow;
    vector<vector<int>> triangle = generate(numsRow);
    for (int i = 0; i < triangle.size(); i++)
    {
        for (int j = 0; j < triangle[i].size(); j++)
        {
            cout << triangle[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}