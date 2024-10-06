#include <bits/stdc++.h>

using namespace std;

void print_pattern_17(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n - i; j++)
        {
            cout << " ";
        }

        // My Solution
        // for (char j = 'A'; j < 'A' + i; j++)
        // {
        //     cout << j;
        // }

        // for (char j = 'A' + i - 2; j >= 'A'; j--)
        // {
        //     cout << j;
        // }

        char ch = 'A';
        int total_characters = i * 2 - 1;
        for (int j = 1; j <= total_characters; j++)
        {
            cout << ch;
            if (j <= total_characters / 2)
            {
                ch++;
            }
            else
            {
                ch--;
            }
        }

        for (int j = 1; j <= n - i; j++)
        {
            cout << " ";
        }
        cout << endl;
    }
}

int main()
{
    print_pattern_17(4);
    return 0;
}
