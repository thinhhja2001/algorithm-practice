import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PartitionArrayAccordingToGivenPivot {

  public static int[] pivotArray(int[] nums, int pivot) {
    Queue<Integer> less = new LinkedList<>();
    Queue<Integer> equal = new LinkedList<>();
    Queue<Integer> greater = new LinkedList<>();

    int[] result = new int[nums.length];

    for (int num : nums) {
      if (num < pivot) {
        less.add(num);
      }
      else if(num==pivot){
        equal.add(num);
      }
      else {
        greater.add(num);
      }
    }

    int index = 0;
    while (!less.isEmpty()) {
      result[index++] = less.poll();
    }

    while (!equal.isEmpty()) {
      result[index++] = equal.poll();
    }

    while (!greater.isEmpty()) {
      result[index++] = greater.poll();
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {9, 12, 5, 10, 14, 3, 10};
    int pivot = 10;
    System.out.println(Arrays.toString(pivotArray(nums, pivot)));
  }
}
