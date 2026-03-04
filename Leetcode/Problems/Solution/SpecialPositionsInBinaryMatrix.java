public class SpecialPositionsInBinaryMatrix {

  public int numSpecial(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;

    int[] rowCount = new int[row];
    int[] colCount = new int[col];

    for (int i = 0; i < row; i++) {
      int count_1 = 0;
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 1) {
          count_1++;
        }
      }
      if (count_1 == 1) {
        rowCount[i] = 1;
      }
    }

    for (int i = 0; i < col; i++) {
      int count_1 = 0;
      for (int j = 0; j < row; j++) {
        if (mat[j][i] == 1) {
          count_1++;
        }
      }
      if (count_1 == 1) {
        colCount[i] = 1;
      }
    }

    int countSpecial = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
          countSpecial++;
        }
      }
    }
    return countSpecial;
  }

  void main() {
    int[][] matrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    System.out.println(numSpecial(matrix));
  }
}
