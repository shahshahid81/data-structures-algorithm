#include <bits/stdc++.h>

using namespace std;
void print_pattern_7(int n)
{
    // My Solution
    // int total_columns{n * 2 - 1};
    // for (int i = 1; i <= n; i++)
    // {
    //     int total_space{(total_columns - (((i - 1) * 2) + 1)) / 2};
    //     for (int j = 0; j < total_space; j++)
    //         cout << " ";
    //     for (int j = 0; j < i * 2 - 1; j++)
    //         cout << "*";
    //     for (int j = 0; j < total_space; j++)
    //         cout << " ";
    //     cout << endl;
    // }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            cout << " ";
        }
        for (int j = 0; j < i * 2 + 1; j++)
        {
            cout << "*";
        }
        for (int j = 0; j < n - i - 1; j++)
        {
            cout << " ";
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_7(5);
    return 0;
}
