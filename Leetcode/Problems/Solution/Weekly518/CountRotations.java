package Weekly518;

public class CountRotations {

  public static int getScore(String s) {
    int score = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        score++;
      }
    }
    return score;
  }


  public static String concatNewString(String s, int rotation) {
    StringBuilder sb = new StringBuilder(s.length());

    sb.append(s);

    for (int i = 0; i < s.length(); i++) {
      int index = i + rotation < s.length() ? i + rotation : i + rotation - s.length();
      sb.setCharAt(index, s.charAt(i));
    }
    return sb.toString();
  }

  public static int countRotations(String s, int k) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      String str = concatNewString(s, i);
      if (getScore(str) == k) {
        cnt++;
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    String s = "abca";
    int k = 0;
    System.out.println(countRotations(s, k));
  }
}
