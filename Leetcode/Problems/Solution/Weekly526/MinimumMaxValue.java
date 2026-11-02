package Weekly526;

import java.util.Arrays;

public class MinimumMaxValue {

  public static long minimumMaxValue(int n, int index, int value) {
    if (index == -1) {
      return value;
    }
    if (value <= 1) {
      return -1;
    }
    if (value % 2 == 0) {
      return value - 2 * index > 1 ? (n - 1 - index) * 2L + value : -1;
    }
    int sqrt = (int) Math.sqrt(value);
    boolean[] isPrime = new boolean[sqrt + 1];
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;
    int minPrime = value;
    for (int i = 2; i <= sqrt; i++) {
      if (isPrime[i]) {
        if (value % i == 0) {
          minPrime = i;
          break;
        }
        for (int j = 2; i * j <= sqrt; j++) {
          isPrime[i * j] = false;
        }
      }
    }

    if (minPrime == value && index != 0) {
      return -1;
    }

    int predecessor = value - minPrime;
    if (minimumMaxValue(1000, index - 1, predecessor) == -1) {
      return -1;
    }
    if (index == n - 1) {
      return value;
    }
    int successor = value + minPrime;
    return successor + 2L * (n - 2 - index);
  }

  public static void main(String[] args) {
    System.out.println(minimumMaxValue(19272149, 19272148, 79851953));
  }
}
