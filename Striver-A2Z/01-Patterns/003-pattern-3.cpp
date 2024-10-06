#include <bits/stdc++.h>

using namespace std;
void print_pattern_3(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << j;
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_3(5);
    return 0;
}
