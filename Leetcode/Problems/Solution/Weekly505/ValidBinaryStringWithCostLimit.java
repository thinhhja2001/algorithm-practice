package Weekly505;

import java.util.LinkedList;
import java.util.List;

public class ValidBinaryStringWithCostLimit {

  public static boolean validString(String str, int k) {
    int sum = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') {
        if (i != 0 && str.charAt(i - 1) == '1') {
          return false;
        }
        sum += i;
      }
    }
    return sum <= k;
  }

  public static List<String> generateValidStrings(int n, int k) {
    StringBuilder binMin = new StringBuilder();
    StringBuilder binMax = new StringBuilder();

    for (int i = 0; i < n; i++) {
      binMin.append("0");
      binMax.append("1");
    }
    Integer min = Integer.valueOf(binMin.toString(), 2);
    Integer max = Integer.valueOf(binMax.toString(), 2);
    String format = "%"+n+"s";
    List<String> res = new LinkedList<>();
    for (int i = min; i <= max; i++) {
      String str = String.format(format, Integer.toBinaryString(i)).replace(' ', '0');
      if (validString(str, k)) {
        res.add(str);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(generateValidStrings(12, 100));
  }
}
