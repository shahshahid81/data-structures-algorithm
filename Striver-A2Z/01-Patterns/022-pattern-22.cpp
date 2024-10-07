#include <bits/stdc++.h>

using namespace std;

void print_pattern_22(int n)
{
  // My solution
  // int total_lines{n * 2 - 1};
  // int center {total_lines / 2};
  // for (int i = 0; i < total_lines; i++)
  // {
  //   for (int j = 0; j < total_lines; j++)
  //   {
  //     int abs_x = abs(center - i);
  //     int abs_y = abs(center - j);
  //     int max_abs = max(abs_x, abs_y);
  //     cout << 1 + max_abs << " ";
  //   }
  //   cout << endl;
  // }

  int total_lines{n * 2 - 1};
  for (int i = 0; i < total_lines; i++)
  {
    for (int j = 0; j < total_lines; j++)
    {
      int left_distance = i;
      int top_distance = j;
      int right_distance = total_lines - 1 - j;
      int bottom_distance = total_lines - 1 - i;
      cout << n - min(min(top_distance, bottom_distance), min(left_distance, right_distance)) << " ";
    }
    cout << endl;
  }
}

int main()
{
  print_pattern_22(4);
  return 0;
}