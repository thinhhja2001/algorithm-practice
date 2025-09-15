import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumNumberWords {

  public int canBeTypedWords(String text, String brokenLetters) {
    List<String> words = Arrays.stream(text.split(" ")).toList();
    Set<Character> brokenChars = brokenLetters.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
    int count = 0;
    for (String word : words) {
      for (Character c : word.toCharArray()) {
        if (brokenChars.contains(c)) {
          count++;
          break;
        }
      }
    }
    return words.size() - count;
  }

  public void main(String[] args) {
    String text = "leet code";
    String brokenLetters = "e";

    System.out.println(canBeTypedWords(text, brokenLetters));
  }
}
