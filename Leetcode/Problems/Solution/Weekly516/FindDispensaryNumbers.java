package Weekly516;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDispensaryNumbers {

  public static List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
    Set<Integer>set = new HashSet<>();
    for(int num:nums){
      set.add(num);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (; lower <= upper; lower++) {
      int num = lower;
      while (num <= upper && !set.contains(num)) {
        num++;
      }
      if (lower <= num - 1) {
        result.add(List.of(lower, num - 1));
      }
      lower = num;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 5};
    int lower = 2;
    int upper = 3;
    System.out.println(findDisappearedNumbers(nums, lower, upper));
  }
}
