package Weekly522;

public class MinRotation2 {

  public static int calculateMin(int a, int b) {
    int min = Math.min(a, b);
    int max = Math.max(a, b);
    return Math.min(max - min, min + 10 - max);
  }

  public static int minRotations(String s) {
    int sum = 0;
    int current = 0;

    for (Character ch : s.toCharArray()) {
      sum += calculateMin(ch - '0', current);
      current = ch - '0';
    }
    return sum;
  }

  public static int minRotations(int n, String s) {
    int minRotation = minRotations(s);
    int result = minRotation;
    for (int i = 0; i < n; i++) {
      int current = i == 0 ? 0 : s.charAt(i - 1) - '0';
      int a = calculateMin(current, s.charAt(i) - '0');
      int b = calculateMin(current, s.charAt(n - 1) - '0');

      result = Math.min(result, minRotation - a + b);
    }

    return result;
  }

  public static void main(String[] args) {
//    System.out.println(minRotations("1502"));
//    System.out.println(minRotations("2051"));
//    System.out.println(minRotations("1205"));
//    System.out.println(minRotations("1520"));
    System.out.println(minRotations(4, "4219"));
  }
}
