public class MaxSubarraySumWithOneDeletion {

  public static int maximumSum(int[] arr) {

    int max = arr[0];
    for (int val : arr) {
      max = Math.max(max, val);
    }

    if (max < 0) {
      return max;
    }

    int[][] matrix = new int[arr.length][2];
    matrix[0][0] = arr[0];
    matrix[0][1] = 0;
    for (int i = 1; i < arr.length; i++) {
      matrix[i][0] = Math.max(matrix[i - 1][0] + arr[i], arr[i]);
      matrix[i][1] = Math.max(matrix[i - 1][0], matrix[i - 1][1] + arr[i]);
    }

    for (int[] ints : matrix) {
      for (int j = 0; j < matrix[0].length; j++) {
        max = Math.max(max, ints[j]);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(maximumSum(new int[]{-1, -1, -2, -1}));
  }
}
