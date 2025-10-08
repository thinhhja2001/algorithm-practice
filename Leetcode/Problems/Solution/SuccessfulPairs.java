import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SuccessfulPairs {

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[] sortedSpells = Arrays.stream(spells).sorted().toArray();
    potions = Arrays.stream(potions).sorted().toArray();
    Map<Integer, Integer> map = new HashMap<>();
    int startIndex = 0;
    for (int i = sortedSpells.length - 1; i >= 0; i--) {
      int spell = sortedSpells[i];
      if (map.get(spell) != null) {
        continue;
      }
      for (int j = startIndex; j < potions.length; j++) {
        if ((long) spell * potions[j] >= success) {
          map.put(spell, potions.length - j);
          startIndex = j;
          break;
        }
      }
    }
    for (int i = 0; i < spells.length; i++) {
      spells[i] = map.getOrDefault(spells[i], 0);
    }
    return spells;
  }

  void main() {
    int[] spells = {3, 1, 2};
    int[] potions = {8, 5, 8};
    int success = 16;
    System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
//    arr = Arrays.stream(arr).sorted().toArray();
//    System.out.println(Arrays.toString(arr));
  }
}
