#include <bits/stdc++.h>

using namespace std;
void print_pattern_13(int n)
{
    int value = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << value++ << " ";
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_13(5);
    return 0;
}
