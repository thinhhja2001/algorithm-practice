package Weekly492;

import java.util.Arrays;

public class MinimumOperationToSortAString {

  static boolean isSorted(String s) {
    char prev = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) < prev) {
        return false;
      }
      prev = s.charAt(i);
    }
    return true;
  }

  public static int minOperations(String s) {
    if (isSorted(s)) {
      return 0;
    }
    if (!isSorted(s) && s.length() == 2) {
      return -1;
    }

    char maxChar = s.charAt(0);
    char minChar = s.charAt(0);
    for(int i=0;i<s.length();i++){
      maxChar = s.charAt(i)>=maxChar?s.charAt(i):maxChar;
      minChar = s.charAt(i)<=minChar?s.charAt(i):minChar;
    }


    if (s.charAt(0) == minChar || s.charAt(s.length() - 1) == maxChar) {
      return 1;
    }

    if (s.charAt(0) != minChar && s.charAt(s.length() - 1) != maxChar) {
      for (int i = 1; i <= s.length() - 2; i++) {
        if (s.charAt(i) == minChar || s.charAt(i) == maxChar) {
          return 2;
        }
      }
      return 3;
    }
    return 1;
  }

  public static void main(String[] args) {
    String s = "jgg";
    System.out.println(minOperations(s));

  }
}
