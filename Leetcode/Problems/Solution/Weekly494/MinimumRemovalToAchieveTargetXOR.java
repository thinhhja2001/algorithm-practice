package Weekly494;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumRemovalToAchieveTargetXOR {

  public static class Temp {

    int result;
    int count;
    List<Integer> currentQueue;

    public Temp(int result, int count, List<Integer> currentQueue) {
      this.result = result;
      this.count = count;
      this.currentQueue = currentQueue;
    }
  }

  public static List<Integer> createNewArrayIgnoreIndex(List<Integer> list, int index) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      if (i == index) {
        continue;
      }
      l.add(list.get(i));
    }

    return l;
  }

  public static int minRemovals(int[] nums, int target) {
    int xor = 0;
    List<Integer> arr = new LinkedList<>();

    for (int num : nums) {
      xor ^= num;
      arr.add(num);
    }
    if (xor == target) {
      return 0;
    }
    Set<Integer> set = new HashSet<>();
    Queue<Temp> queue = new LinkedList<>();
    set.add(xor);
    queue.add(new Temp(xor, 0, new ArrayList<>(arr)));

    while (!queue.isEmpty()) {
      Temp curTemp = queue.poll();
      for (int i = 0; i < curTemp.currentQueue.size(); i++) {

        Integer num = curTemp.currentQueue.get(i);
        int result = curTemp.result ^ num;
        if ((result) == target) {
          return curTemp.count + 1;
        }
        if (!set.contains(result)) {
          set.add(result);
          queue.add(new Temp(result, curTemp.count + 1, createNewArrayIgnoreIndex(curTemp.currentQueue, i)));
        }
      }
    }
    return target == 0 ? nums.length : -1;
  }

  public static void main(String[] args) {
    int[] nums = {5, 10, 58, 109, 122, 46, 45, 70, 40, 0, 109};
    int target = 50;
    System.out.println(minRemovals(nums, target));
  }
}
