#include <bits/stdc++.h>

using namespace std;

void print_pattern_19(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = n - i; j > 0; j--)
        {
            cout << "*";
        }
        for (int j = 0; j <= 2 * i; j++)
        {
            cout << " ";
        }
        for (int j = n - i; j > 0; j--)
        {
            cout << "*";
        }
        cout << endl;
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << "*";
        }

        for (int j = 0; j <= 2 * (n - 1 - i); j++)
        {
            cout << " ";
        }

        for (int j = 0; j <= i; j++)
        {
            cout << "*";
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_19(5);
    return 0;
}
