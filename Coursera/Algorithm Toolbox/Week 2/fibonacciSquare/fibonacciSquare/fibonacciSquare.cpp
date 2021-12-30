
#include <iostream>
#include <vector>
using namespace std;


vector< int64_t> pisanoPeriod(int64_t m)
{
	vector<int64_t>period;
	period.push_back(0);
	period.push_back(1);
	while (true)
	{
		int64_t x = (period[period.size() - 1] + period[period.size() - 2]) % m;
		period.push_back(x);
		if (period[period.size() - 1] == 1 && period[period.size() - 2] == 0)
		{
			break;
		}
	}
	return period;
}
int64_t lastDigitSumFibo(int64_t n)
{
	vector<int64_t>period = pisanoPeriod(10);
	int64_t periodSize = period.size() - 2;
	period.pop_back();
	period.pop_back();
	int64_t sumPisano = 0;
	for (int64_t i = 0; i < periodSize; i++)
	{
		sumPisano = (sumPisano + period[i]) % 10;
	}
	int64_t modulo = n % periodSize;
	int64_t sum = 0;
	for (int64_t i = 0; i < modulo; i++)
	{
		sum = (sum + period[i]) % 10;
	}
	return sum;
}
int64_t lastDigitSumFiboAgain(int64_t m, int64_t n)
{
	int64_t a = lastDigitSumFibo(m);
	int64_t b = lastDigitSumFibo(n + 1);
	if (b < a) {
		b += 10;
	}
	return b - a;
}
int64_t lastDigitSquareFibo(int64_t m)
{
	int64_t a = lastDigitSumFiboAgain(m, m);
	int64_t b = lastDigitSumFiboAgain(m + 1, m + 1);
	return (b * a) % 10;
}
int64_t lastDigitSquareFibo(int64_t m)
{
	int64_t a = lastDigitSumFiboAgain(m, m);
	int64_t b = lastDigitSumFiboAgain(m + 1, m + 1);
	return (b * a) % 10;
}
int main()
{
	int64_t n;
	cin >> n;
	cout << lastDigitSquareFibo(n) << endl;
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