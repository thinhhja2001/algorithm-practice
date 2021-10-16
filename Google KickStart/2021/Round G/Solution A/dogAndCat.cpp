#include <iostream>
#include <algorithm>
using namespace std;

string determineAllDogEaten(string animal, int dogPortion, int catPortion, int bonus)
{
    int countDog = count(animal.begin(), animal.end(), 'D');
    int countCat = count(animal.begin(), animal.end(), 'C');
    if (countDog == 0)
    {
        return "YES";
    }

    if (countDog > dogPortion)
    {
        return "NO";
    }

    for (int i = 0; i < animal.size(); i++)
    {
        if (animal[i] == 'D')
        {
            catPortion += bonus;
            countDog--;
        }
        if (animal[i] == 'C')
        {
            if (catPortion == 0)
            {
                if (countDog == 0)
                {
                    return "YES";
                }
                else
                {
                    return "NO";
                }
            }
            else
            {
                catPortion--;
            }
        }
    }
    return "YES";
}
int main()
{
    int testCase;
    cin >> testCase;
    for (int i = 0; i < testCase; i++)
    {
        int size;
        cin >> size;
        int dogPortion;
        cin >> dogPortion;
        int catPortion;
        cin >> catPortion;
        int bonus;
        cin >> bonus;
        string animal;
        cin >> animal;
        cout << "Case #" << i + 1 << ": " << determineAllDogEaten(animal, dogPortion, catPortion, bonus) << endl;
    }
}