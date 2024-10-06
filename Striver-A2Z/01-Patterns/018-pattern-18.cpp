#include <bits/stdc++.h>

using namespace std;
void print_pattern_18(int n)
{
    for (int i = 1; i <= n; i++)
    {
        // My Solution
        // char ch = 'A' + n - i;
        // for (int j = 1; j <= i; j++)
        // {
        //     cout << ch << " ";
        //     ch++;
        // }

        for(char j = 'A' + n - i; j <= 'A' + n - 1; j++) {
            cout << j << " ";
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_18(5);
    return 0;
}
