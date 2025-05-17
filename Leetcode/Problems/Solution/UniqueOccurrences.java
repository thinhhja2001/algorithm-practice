import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {

  public static boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr) {
      Integer value = map.getOrDefault(i, 0);
      map.put(i, value + 1);
    }
    List<Integer> values = map.values().stream().toList();
    Set<Integer> valueSet = new HashSet<>(values);
    return values.size() == valueSet.size();
  }

  public static void main(String[] args) {
    int[] arr = {1, 2};
    System.out.println(uniqueOccurrences(arr));
  }
}
