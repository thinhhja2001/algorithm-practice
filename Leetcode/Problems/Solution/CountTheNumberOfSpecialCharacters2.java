import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountTheNumberOfSpecialCharacters2 {

  public static int numberOfSpecialChars(String word) {
    Map<Character, Integer> lowercaseMapper = new HashMap<>();
    Map<Character, Integer> uppercaseMapper = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c >= 'a' && c <= 'z') {
        lowercaseMapper.put(c, i);
      }
      if (c >= 'A' && c <= 'Z') {
        uppercaseMapper.putIfAbsent(c, i);
      }
    }

    int countSpecialChar = 0;
    for (char c : lowercaseMapper.keySet()) {
      Integer lastLowerCaseIndex = lowercaseMapper.get(c);
      Integer firstUpperCaseIndex = uppercaseMapper.get(Character.toUpperCase(c));
      if (Objects.nonNull(firstUpperCaseIndex) && lastLowerCaseIndex < firstUpperCaseIndex) {
        countSpecialChar++;
      }
    }
    return countSpecialChar;
  }

  public static void main(String[] args) {
    System.out.println(numberOfSpecialChars("AbBCab"));
  }
}
