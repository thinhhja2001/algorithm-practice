import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {

  public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();

    for (int k : nums1) {
      s1.add(k);
    }
    for (int j : nums2) {
      s2.add(j);
    }

    List<Integer> l1 = new ArrayList<>();
    for (Integer element : s1) {
      if (!s2.contains(element)) {
        l1.add(element);
      }
    }

    List<Integer> l2 = new ArrayList<>();
    for (Integer element : s2) {
      if (!s1.contains(element)) {
        l2.add(element);
      }
    }

    return List.of(l1, l2);
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3};
    int[] nums2 = {2, 4, 6};
    System.out.println(findDifference(nums1, nums2));
  }
}
