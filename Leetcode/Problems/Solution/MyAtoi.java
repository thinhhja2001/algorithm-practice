public class MyAtoi {

  public static int myAtoi(String s) {
    Boolean isNegative = null;
    int i = 0;
    while (i < s.length() && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
      char c = s.charAt(i);
      if (c == '-' || c == '+') {
        if (isNegative == null) {
          isNegative = c == '-';
        } else {
          return 0;
        }
      } else if (s.charAt(i) == ' ' && isNegative == null) {
        i++;
        continue;
      } else {
        return 0;
      }
      i++;
    }
    if (isNegative == null) {
      isNegative = false;
    }
    int num = 0;
    while (i < s.length()) {
      if (s.charAt(i) < '0' || s.charAt(i) > '9') {
        break;
      }
      if ((Integer.MAX_VALUE - (s.charAt(i) - '0')) / 10 < num) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

      }
      num = num * 10 + s.charAt(i) - '0';
      i++;
    }
    return isNegative ? num * -1 : num;
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("  -  413"));
  }
}
