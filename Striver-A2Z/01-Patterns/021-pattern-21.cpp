#include <bits/stdc++.h>

using namespace std;
void print_pattern_21(int n)
{
    // My Solution
    // for (int i = 1; i <= n; i++)
    // {
    //     if (i == 1 || i == n)
    //     {
    //         for (int j = 1; j <= n; j++)
    //         {
    //             cout << "*";
    //         }
    //     }
    //     else
    //     {
    //         cout << "*";
    //         for (int j = 1; j <= n - 2; j++)
    //         {
    //             cout << " ";
    //         }
    //         cout << "*";
    //     }
    //     cout << endl;
    // }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            char ch = ' ';
            if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
            {
                ch = '*';
            }
            cout << ch;
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_21(4);
    return 0;
}
