#include <iostream>
#include <vector>
using namespace std;
vector<int> getRow(int rowIndex)
{
    if (rowIndex == 0)
    {
        return {1};
    }
    vector<vector<int>> pascalTriangle(rowIndex+1);
    pascalTriangle[0] = {1};
    pascalTriangle[1] = {1, 1};
    for (int i = 2; i <= rowIndex; i++)
    {
        pascalTriangle.at(i).resize(i + 1);
        pascalTriangle.at(i).at(0) = 1;
        pascalTriangle.at(i).at(i) = 1;
    }
    for (int i = 2; i <= rowIndex; i++)
    {
        for (int j = 1; j < i; j++)
        {
            pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
        }
    }
    return pascalTriangle[rowIndex];
}
int main()
{
    int numsRow;
    cin >> numsRow;
    vector<int> pascalTriangle = getRow(numsRow);
    for (int i = 0; i < pascalTriangle.size(); i++)
    {
        cout << pascalTriangle[i] << " ";
    }
    cout << endl;
}