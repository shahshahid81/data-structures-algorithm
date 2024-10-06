#include <bits/stdc++.h>

using namespace std;
void print_pattern_1(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << "*";
        }
        cout << endl;
    }
}

int main()
{
    int n = 4;
    print_pattern_1(n);
    return 0;
}
