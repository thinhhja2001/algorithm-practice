package Weekly512;

public class LargestIntegerWithGivenDigitSum {

  public static int calculateDigitSum(int n) {
    int sum = 0;
    while (n != 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }

  public static int largestInteger(int n, int s) {
    int largest = (int) Math.pow(10, n) - 1;

    for (int i = largest; i >= 0; i--) {
      if (calculateDigitSum(i) == s) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(largestInteger(5, 0));
  }

}
