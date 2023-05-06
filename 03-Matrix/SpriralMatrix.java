public class SpriralMatrix {

  public static void spiralPrint(int matrix[][]) {
    if (matrix.length == 0) return;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i].length == 0) return;
    }

    int count = 0, total = matrix.length * matrix[0].length;
    int row = 0, column = 0;
    int minRow = 0, maxRow = matrix.length - 1;
    int minColumn = 0, maxColumn = matrix[0].length - 1;
    StringBuilder sb = new StringBuilder();

    while (
      count < total &&
      row >= minRow &&
      row <= maxRow &&
      column >= minColumn &&
      column <= maxColumn
    ) {
      while (column <= maxColumn && count < total) {
        sb.append(matrix[row][column++] + " ");
        count++;
      }
      column--;
      row++;
      minRow++;

      while (row <= maxRow && count < total) {
        sb.append(matrix[row++][column] + " ");
        count++;
      }
      row--;
      column--;
      maxColumn--;

      while (column >= minColumn && count < total) {
        sb.append(matrix[row][column--] + " ");
        count++;
      }
      column++;
      row--;
      maxRow--;

      while (row >= minRow && count < total) {
        sb.append(matrix[row--][column] + " ");
        count++;
      }
      row++;
      column++;
      minColumn++;
    }

    System.out.println(sb.toString().trim());
  }
}
/**
   0  1  2  3
0  1  2  3  4 
1  5  6  7  8 
2  9 10 11 12 
3 13 14 15 16

min row = 0
max row = 3

min col = 0
max col = 3

0 0 1   inc col, min row = 0, max row = 3, min col = 0, max col = 3
0 1 2   inc col, min row = 0, max row = 3, min col = 0, max col = 3
0 2 3   inc col, min row = 0, max row = 3, min col = 0, max col = 3
0 3 4   inc col, min row = 1, max row = 3, min col = 0, max col = 3
1 3 8   inc row, min row = 1, max row = 3, min col = 0, max col = 3 
2 3 12  inc row, min row = 1, max row = 3, min col = 0, max col = 3
3 3 16  inc row, min row = 1, max row = 3, min col = 0, max col = 2
3 2 15  dec col, min row = 1, max row = 3, min col = 0, max col = 2
3 1 14  dec col, min row = 1, max row = 3, min col = 0, max col = 2
3 0 13  dec col, min row = 1, max row = 2, min col = 0, max col = 2
2 0 9   dec row, min row = 1, max row = 2, min col = 0, max col = 2
1 0 5   dec row, min row = 1, max row = 2, min col = 1, max col = 2
1 1 6   inc col, min row = 1, max row = 2, min col = 1, max col = 2
1 2 7   inc col, min row = 2, max row = 2, min col = 1, max col = 2
2 2 11  inc row, min row = 2, max row = 2, min col = 1, max col = 1
2 1 10  dec row, min row = 2, max row = 2, min col = 1, max col = 1


inc col
inc row
dec col
dec row


Algo:
print and increment col till the limit, once you cross the limit, inc row and inc min row by 1
print and increment row till the limit, once you cross the limit, dec col and dec max col by 1
print and decrement col till the limit, once you cross the limit, dec row and max row by 1
print and decrement row till the limit, once you cross the limit, inc col and inc min col by 1


while min row >= row <= max row and min col >= col <= max col

    while col <= max col, print and increment col
    dec col, inc row and inc min row by 1
    
    while row <= max row, print and increment row 
    dec row, dec col, dec max col by 1 
    
    while col >= min col, print and decrement col
    inc col, dec row, dec max row by 1
    
    while row >= min row, print and decrement row
    inc row, inc col, inc min col by 1

   0
0  1
1  2 
2  3
3  4

row = 3
col = -1
min row = 1
max row = 3
min col = 0
max col = -1

1
2
3
4

*/
