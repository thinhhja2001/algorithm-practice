import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinationOfPhoneNumber {


  public List<String> letterCombinations(String digits) {
    Map<Integer, List<Character>> map = new HashMap<>();
    int asciiStart = 97;
    for (int i = 2; i <= 9; i++) {
      map.put(i, new ArrayList<>());
      for (int j = 0; j < 3; j++) {

        map.get(i).add((char) asciiStart++);
        if ((i == 7 || i == 9) && j == 2) {
          map.get(i).add((char) asciiStart++);
        }
      }
    }
    if (digits.isEmpty()) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();

    int i = 0;
    List<Character> ch = map.get(digits.charAt(i) - '0');
    for (Character c : ch) {
      result.add(String.valueOf(c));
    }
    i++;

    for (; i < digits.length(); i++) {
      int c = digits.charAt(i) - '0';
      List<Character> characters = map.get(c);
      List<String> temp = new ArrayList<>();
      for (Character character : characters) {
        for (String str : result) {
          temp.add(str + character);
        }
      }
      result = temp;
    }
    return result;
  }

  void main() {
    System.out.println(letterCombinations("7"));
  }
}
