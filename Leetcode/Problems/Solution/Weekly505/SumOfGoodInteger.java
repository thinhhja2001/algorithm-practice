package Weekly505;

public class SumOfGoodInteger {

  public static int sumOfGoodIntegers(int n, int k) {
    int left = Math.max(n - k, 0);
    int right = Math.abs(k + n);
    int sum = 0;
    for (int i = left; i <= right; i++) {
      if ((i & n) == 0) {
        sum += i;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int n = 1, k = 13;
    System.out.println(sumOfGoodIntegers(n, k));
  }
}
