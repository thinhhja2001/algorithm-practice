import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFlood {

  public int[] avoidFlood(int[] rains) {
    int n = rains.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    TreeSet<Integer> sunnyDays = new TreeSet<>();
    Map<Integer, Integer> lastRainedLakes = new HashMap<>();

    for (int day = 0; day < n; day++) {
      int lake = rains[day];
      if (lake > 0) {
        if (lastRainedLakes.containsKey(lake)) {
          int lastRainDay = lastRainedLakes.get(lake);
          Integer dryDay = sunnyDays.higher(lastRainDay);
          if (dryDay == null) {
            return new int[0];
          }
          result[day] = lake;
          sunnyDays.remove(day);
        }

        lastRainedLakes.put(lake, day);


      } else {
        sunnyDays.add(day);
        result[day] = 1;
      }
    }
    return result;
  }

  void main() {
    int[] rains = {1, 2, 0, 0, 2, 1};
    System.out.println(Arrays.toString(avoidFlood(rains)));
  }
}
