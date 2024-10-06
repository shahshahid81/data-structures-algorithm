#include <bits/stdc++.h>

using namespace std;
void print_pattern_6(int n)
{
    // My solution, also returns the same result but doesn't follow the 4 steps.
    // for (int i = n; i > 0; i--)
    // {
    //     for (int j = 1; j <= i; j++)
    //     {
    //         cout << j;
    //     }
    //     cout << endl;
    // }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n - i + 1; j++)
        {
            cout << j;
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_6(5);
    return 0;
}
