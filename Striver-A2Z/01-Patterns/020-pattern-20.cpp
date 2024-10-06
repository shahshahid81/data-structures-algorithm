#include <bits/stdc++.h>

using namespace std;
void print_pattern_20(int n)
{
    for (int i = 1; i <= (2 * n) - 1; i++)
    {
        int max_stars = i > n ? (2 * n) - i : i;
        for (int j = 1; j <= max_stars; j++)
        {
            cout << "*";
        }

        for (int j = 0; j < 2 * (n - max_stars); j++)
        {
            cout << " ";
        }

        for (int j = 1; j <= max_stars; j++)
        {
            cout << "*";
        }

        cout << endl;
    }
}

int main()
{
    print_pattern_20(5);
    return 0;
}
