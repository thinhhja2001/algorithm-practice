public class MatrixSimilarityAfterCyclicShifts {

  public static boolean areSimilar(int[][] mat, int k) {
    int row = mat.length;
    int col = mat[0].length;
    int actualShiftCount = k % col;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int resultIndex = 0;
        if (i % 2 == 0) {
          resultIndex = j - actualShiftCount < 0 ? j - actualShiftCount + col : j - actualShiftCount;
        }
        if (i % 2 != 0) {
          resultIndex = j + actualShiftCount >= col ? j + actualShiftCount - col : j + actualShiftCount;
        }
        if (mat[i][j] != mat[i][resultIndex]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] mat = {{1, 2}};
    int k = 1;
    System.out.println(areSimilar(mat, k));
  }
}
