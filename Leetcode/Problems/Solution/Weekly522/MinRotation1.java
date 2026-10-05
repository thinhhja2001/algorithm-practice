package Weekly522;

public class MinRotation1 {

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

  public static void main(String[] args) {
    System.out.println(minRotations("1200210200"));
  }
}
