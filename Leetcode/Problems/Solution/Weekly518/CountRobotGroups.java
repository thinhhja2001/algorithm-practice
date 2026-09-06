package Weekly518;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountRobotGroups {

  public static int countGroups(int[] position, int[] speed, int distance) {
    int count = 0;
    Set<Integer> ignoredSpeed = new HashSet<>();
    for (int i = 0; i < position.length - 1; i++) {
      if (position[i + 1] - position[i] <= distance) {
        ignoredSpeed.add(i);
      }
    }

    List<Integer> mergedSpeed = new ArrayList<>();
    for (int i = 0; i < speed.length; i++) {
      if (!ignoredSpeed.contains(i)) {
        mergedSpeed.add(speed[i]);
      }
    }

    boolean[] merged = new boolean[mergedSpeed.size()];

    for (int i = mergedSpeed.size() - 2; i >= 0; i--) {
      if (mergedSpeed.get(i) > mergedSpeed.get(i + 1)) {
        mergedSpeed.set(i, mergedSpeed.get(i + 1));
        merged[i] = true;
      }
    }

    for (boolean b : merged) {
      if (!b) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] position = new int[]{9};
    int[] speed = new int[]{8};
    int distance = 5;
    System.out.println(countGroups(position, speed, distance));
  }
}
