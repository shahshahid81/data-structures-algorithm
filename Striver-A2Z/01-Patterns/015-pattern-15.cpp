#include <bits/stdc++.h>

using namespace std;
void print_pattern_15(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (char j = 'A'; j < 'A' + (n + 1 - i); j++)
        {
            cout << j;
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_15(5);
    return 0;
}
