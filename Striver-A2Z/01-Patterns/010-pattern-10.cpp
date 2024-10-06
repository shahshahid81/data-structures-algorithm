#include <bits/stdc++.h>

using namespace std;
void print_pattern_10(int n)
{

    int total_lines{2 * n - 1};
    for (int i = 1; i <= total_lines; i++)
    {
        int stars = i > n ? total_lines - i + 1 : i;
        for (int j = 1; j <= stars; j++)
        {
            cout << "*";
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_10(5);
    return 0;
}
