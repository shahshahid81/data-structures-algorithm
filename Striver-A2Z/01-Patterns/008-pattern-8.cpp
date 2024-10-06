#include <bits/stdc++.h>

using namespace std;
void print_pattern_8(int n)
{
    // My solution, also returns the same result but doesn't follow the 4 steps.
    // for (int i = n - 1; i >= 0; i--)
    // {
    //     for (int j = 0; j < n - i - 1; j++)
    //     {
    //         cout << " ";
    //     }
    //     for (int j = 0; j < i * 2 + 1; j++)
    //     {
    //         cout << "*";
    //     }
    //     for (int j = 0; j < n - i - 1; j++)
    //     {
    //         cout << " ";
    //     }
    //     cout << endl;
    // }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            cout << " ";
        }
        for (int j = 0; j < n * 2 - (i * 2 + 1); j++)
        {
            cout << "*";
        }
        for (int j = 0; j < i; j++)
        {
            cout << " ";
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_8(5);
    return 0;
}
