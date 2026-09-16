package Weekly519;

import java.util.*;

public class PalindromeMinOperations {

  public static Set<Long> generateAllPalindromes() {
    Set<Long> palindromes = new HashSet<>();

    // 1-digit palindromes: 1-9
    for (int i = 1; i <= 9; i++) {
      palindromes.add((long) i);
    }

    // 2-digit palindromes: 11, 22, 33, ..., 99
    for (int i = 1; i <= 9; i++) {
      long palindrome = i * 10L + i;
      palindromes.add(palindrome);
    }

    // 3-digit palindromes: 101, 111, 121, ..., 999
    for (int i = 1; i <= 9; i++) {
      for (int j = 0; j <= 9; j++) {
        long palindrome = i * 100L + j * 10 + i;
        palindromes.add(palindrome);
      }
    }

    // 4-digit palindromes: 1001, 1111, 1221, ..., 9999
    for (int i = 1; i <= 9; i++) {
      for (int j = 0; j <= 9; j++) {
        long palindrome = i * 1000L + j * 100 + j * 10 + i;
        palindromes.add(palindrome);
      }
    }

    // 5-digit palindromes: 10001, 10101, ..., 99999
    for (int i = 1; i <= 9; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = 0; k <= 9; k++) {
          long palindrome = i * 10000L + j * 1000 + k * 100 + j * 10 + i;
          palindromes.add(palindrome);
        }
      }
    }

    // 6-digit palindromes: 100001, 101101, ..., 999999
    for (int i = 1; i <= 9; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = 0; k <= 9; k++) {
          long palindrome = i * 100000L + j * 10000 + k * 1000 + k * 100 + j * 10 + i;
          palindromes.add(palindrome);
        }
      }
    }

    // 7-digit palindromes: 1000001, 1001001, ..., 9999999
    for (int i = 1; i <= 9; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = 0; k <= 9; k++) {
          for (int l = 0; l <= 9; l++) {
            long palindrome = i * 1000000L + j * 100000 + k * 10000 + l * 1000 + k * 100 + j * 10 + i;
            palindromes.add(palindrome);
          }
        }
      }
    }
    return palindromes;
  }

  static Set<Long> palindromes;

  static {
    palindromes = generateAllPalindromes();
  }

  public static long minOperations(int[] nums) {
    long count = 0;
    for (int num : nums) {
      long operation = 0;

      long leftNum = num;
      long rightNum = num;

      while (!palindromes.contains(leftNum) && !palindromes.contains(rightNum)) {
        leftNum -= 2L;
        rightNum += 2L;
        operation++;
      }
      count += operation;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {10, 12, 14, 16};
    System.out.println(minOperations(nums));
  }
}