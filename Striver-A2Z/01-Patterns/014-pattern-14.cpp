#include <bits/stdc++.h>

using namespace std;
void print_pattern_14(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (char j = 'A'; j < 'A' + i; j++)
        {
            cout << j;
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_14(5);
    return 0;
}
