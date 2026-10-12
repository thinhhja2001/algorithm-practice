package Weekly523;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrimeSubsetSelectionI {

  public static List<Integer> maxPrimes(int n, int s) {
    boolean[] isPrime = new boolean[n + 1];

    Arrays.fill(isPrime, true);

    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) {
        for (int j = 2; i * j < isPrime.length; j++) {
          isPrime[i * j] = false;
        }
      }
    }

    long curSum = 0;

    List<Integer> result = new LinkedList<>();

    for (int i = 2; i < isPrime.length; i++) {
      if (curSum + i > s) {
        break;
      }

      if (isPrime[i] && curSum + i <= s) {
        curSum += i;
        result.add(i);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(maxPrimes(7, 20));
  }
}
