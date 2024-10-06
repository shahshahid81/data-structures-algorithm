#include <bits/stdc++.h>

using namespace std;
void print_pattern_11(int n)
{
    for (int i = 1; i <= n; i++)
    {
        int start = i % 2 == 0 ? 0 : 1;
        for (int j = 0; j < i; j++)
        {
            cout << start << " ";
            start = 1 - start;
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_11(5);
    return 0;
}
