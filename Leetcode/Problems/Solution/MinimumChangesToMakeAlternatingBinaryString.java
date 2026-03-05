public class MinimumChangesToMakeAlternatingBinaryString {

  public int minOperations(String s) {
    StringBuilder sb0 = new StringBuilder("0");
    StringBuilder sb1 = new StringBuilder("1");

    while (sb0.length() != s.length()) {
      sb0.append(sb0.charAt(sb0.length() - 1) == '0' ? '1' : '0');
      sb1.append(sb0.charAt(sb0.length() - 1) == '0' ? '1' : '0');
    }
    int totalChange_0 = 0;
    int totalChange_1 = 0;
    for (int i = 0; i < sb0.length(); i++) {
      if (sb0.charAt(i) != s.charAt(i)) {
        totalChange_0++;
      }
      if (sb1.charAt(i) != s.charAt(i)) {
        totalChange_1++;
      }
    }
    return Math.min(totalChange_0, totalChange_1);
  }

  void main() {
    String s = "1111";

    System.out.println(minOperations(s));
  }
}
