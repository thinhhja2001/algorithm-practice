public class StringCompression {

  public static int compress(char[] chars) {
    char cur = chars[0];
    int count = 0;
    int sum = 0;
    int curCharIndex = 0;
    for (int i = 0; i < chars.length; i++) {
      if (cur == chars[i]) {
        count++;
      } else {
        String strCount = Integer.toString(count);
        chars[curCharIndex++] = cur;
        if (count != 1) {
          for (char ch : strCount.toCharArray()) {
            chars[curCharIndex++] = ch;
          }
        }

        int compressedNumber = count == 1 ? Integer.toString(count).length() : Integer.toString(count).length() + 1;
        sum += compressedNumber;
        count = 1;
        cur = chars[i];
      }
    }
    chars[curCharIndex++] = cur;
    if (count != 1) {
      String strCount = Integer.toString(count);
      for (char ch : strCount.toCharArray()) {
        chars[curCharIndex++] = ch;
      }
    }
    int compressedNumber = count == 1 ? Integer.toString(count).length() : Integer.toString(count).length() + 1;
    sum += compressedNumber;
    return sum;
  }


  public static void main(String[] args) {
    char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c'};
    int length = compress(chars);
    System.out.println(length);
    for (int i = 0; i < length; i++) {
      System.out.print(chars[i]);
    }
  }
}
