import java.util.PriorityQueue;
import java.util.Set;

public class SortVowels {

  public String sortVowels(String s) {
    Set<Character> VOWELS = Set.of('u', 'e', 'o', 'a', 'i', 'U', 'E', 'O', 'A', 'I');
    PriorityQueue<Character> vowelsList = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();
    for (Character c : s.toCharArray()) {
      if (VOWELS.contains(c)) {
        sb.append("_");
        vowelsList.add(c);
        continue;
      }
      sb.append(c);
    }
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '_') {

        sb.setCharAt(i, vowelsList.poll());
      }
    }
    return sb.toString();
  }

  void main() {
    String s = "lEetcOde";
    System.out.println(sortVowels(s));
  }
}
