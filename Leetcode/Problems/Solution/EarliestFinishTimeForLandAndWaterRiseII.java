import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EarliestFinishTimeForLandAndWaterRiseII {

  public static int earliest(int[] firstStartTime, int[] firstDuration, int[] secStartTime, int[] secDuration) {
    int maxStartTime = Math.max(firstStartTime[firstStartTime.length - 1], secStartTime[secStartTime.length - 1]);
    int[] prefixMin = new int[maxStartTime + 1];

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < firstStartTime.length; i++) {
      int val = map.getOrDefault(firstStartTime[i],1_000_000);
      map.put(firstStartTime[i], Math.min(val,firstDuration[i]));
    }

    prefixMin[0] = 1_000_000;
    for (int i = 1; i <= maxStartTime; i++) {
      prefixMin[i] = Math.min(prefixMin[i - 1], map.getOrDefault(i, 1_000_000));
    }

    SimpleEntry<Integer, Integer>[] suffixMin = new SimpleEntry[maxStartTime + 1];
    suffixMin[maxStartTime] = new SimpleEntry<>(firstStartTime[firstStartTime.length - 1],
        firstDuration[firstStartTime.length - 1]);

    Comparator<SimpleEntry<Integer, Integer>> cmp = (o1, o2) ->
        (o1.getValue() - o2.getValue()) + (o1.getKey() - o2.getKey());

    for (int i = maxStartTime - 1; i >= 0; i--) {
      SimpleEntry<Integer, Integer> previous = suffixMin[i + 1];
      SimpleEntry<Integer, Integer> current = new SimpleEntry<>(i, map.getOrDefault(i, 1_000_000));
      suffixMin[i] = cmp.compare(current, previous) < 0 ? current : previous;
    }
    int min = 1_000_000;
    for (int i = 0; i < secStartTime.length; i++) {
      int endTime = secStartTime[i] + secDuration[i];
      int prefixKey = Math.min(endTime, maxStartTime);
      int prefix = prefixMin[prefixKey];

      int suffixKey = Math.min(endTime, maxStartTime);
      SimpleEntry<Integer, Integer> suffix = suffixMin[suffixKey];

      int suffixFinishTime = Math.max(endTime, suffix.getKey()) + suffix.getValue();
      int minFinishTime = Math.min(endTime + prefix, suffixFinishTime);
      min = Math.min(min, minFinishTime);
    }
    return min;
  }

  public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime,
      int[] waterDuration) {
    SimpleEntry<Integer, Integer>[] lands = new SimpleEntry[landStartTime.length];
    for (int i = 0; i < landStartTime.length; i++) {
      lands[i] = new SimpleEntry<>(landStartTime[i], landDuration[i]);
    }
    Arrays.sort(lands, Map.Entry.comparingByKey());

    for (int i = 0; i < landStartTime.length; i++) {
      landStartTime[i] = lands[i].getKey();
      landDuration[i] = lands[i].getValue();
    }

    SimpleEntry<Integer, Integer>[] waters = new SimpleEntry[waterStartTime.length];
    for (int i = 0; i < waterStartTime.length; i++) {
      waters[i] = new SimpleEntry<>(waterStartTime[i], waterDuration[i]);
    }

    Arrays.sort(waters, Map.Entry.comparingByKey());

    for (int i = 0; i < waterStartTime.length; i++) {
      waterStartTime[i] = waters[i].getKey();
      waterDuration[i] = waters[i].getValue();
    }
    int waterStartFirst = earliest(landStartTime, landDuration, waterStartTime, waterDuration);
    int landStartFirst = earliest(waterStartTime, waterDuration, landStartTime, landDuration);
    return Math.min(waterStartFirst, landStartFirst);
//    return 1;
  }

  public static void main(String[] args) {
    int[] landStartTime = {59, 99, 55, 12, 55},
        landDuration = {87, 7, 3, 7, 45},
        waterStartTime = {37, 27, 34, 20, 16, 13, 70, 20, 86, 13, 81, 61, 37},
        waterDuration = {32, 9, 13, 66, 47, 100, 41, 6, 87, 11, 49, 61, 99};
    System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
  }
}
