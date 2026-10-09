public class MinInsertionToBalanceParentheses {

  public static int minInsertions(String s) {
    int openCount = 0;
    int mismatch = 0;
    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) == '(') {
        openCount++;
      } else {
        if (openCount != 0) {
          openCount--;
        } else {
          mismatch++;
        }
        if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
          i++;
        } else {
          mismatch++;
        }
      }
    }

    return mismatch + openCount * 2;
  }

  public static void main(String[] args) {
    System.out.println(minInsertions(")))"));
  }
}
