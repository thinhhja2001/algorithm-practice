// PlacingParentheses.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <cassert>
#include <algorithm>
using namespace std;

int64_t makeExpression(int64_t a, int64_t b, char op) {
	if (op == '*') {
		return a * b;
	}
	else if (op == '+') {
		return a + b;
	}
	else if (op == '-') {
		return a - b;
	}
	else {
		assert(0);
	}
}
int64_t placingParenthesis(string expression)
{
	int64_t length = expression.size();
	int64_t countOperand = (length + 1) / 2;

	vector<vector<int64_t>>M(countOperand, vector<int64_t>(countOperand, 0));
	vector<vector<int64_t>>m(countOperand, vector<int64_t>(countOperand, 0));

	for (int64_t i = 0; i < countOperand; i++)
	{
		M[i][i] = expression[2 * i] - '0';
		m[i][i] = expression[2 * i] - '0';
	}

	for (int64_t s = 0; s < countOperand - 1; s++)
	{
		for (int64_t i = 0; i < countOperand - s - 1; i++)
		{
			int64_t j = i + s + 1;

			int64_t maxValue = -100000000000000;
			int64_t minValue = 10000000000000000;

			for (int64_t k = i; k < j; k++)
			{
				int64_t a = makeExpression(m[i][k], m[k + 1][j], expression[2 * k + 1]);
				int64_t b = makeExpression(m[i][k], M[k + 1][j], expression[2 * k + 1]);
				int64_t c = makeExpression(M[i][k], m[k + 1][j], expression[2 * k + 1]);
				int64_t d = makeExpression(M[i][k], M[k + 1][j], expression[2 * k + 1]);

				minValue = min({ minValue,a,b,c,d });
				maxValue = max({ maxValue,a,b,c,d });
			}

			m[i][j] = minValue;
			M[i][j] = maxValue;
		}
	}

	return M[0][countOperand - 1];
}
int main()
{
	string expression;
	cin >> expression;
	cout << placingParenthesis(expression) << endl;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
