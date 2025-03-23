public class ReverseWordsInAString {

  public static String reverseWords(String s) {
    String result = "";
    String curValue = "";

    int startIndex = 0;
    int endIndex = s.length() - 1;
    while (startIndex < s.length()) {
      if (s.charAt(startIndex) != ' ') {
        break;
      }
      startIndex++;
    }

    while (endIndex >= 0) {
      if (s.charAt(endIndex) != ' ') {
        break;
      }
      endIndex--;
    }

    for (int i = endIndex; i >= startIndex; i--) {
      char c = s.charAt(i);
      if (c != ' ') {
        curValue = c + curValue;
      }
      if (c == ' ' && s.charAt(i - 1) != ' ') {
        result += curValue + ' ';
        curValue = "";
      }
    }
    result = result + curValue;
    return result;
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("a good   example"));
  }
}

