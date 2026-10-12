package Weekly523;

import java.util.LinkedList;
import java.util.List;

public class ThreeFibonacciSum {

  public static boolean threeFibonacciSum(int n) {
    List<Integer> queue = new LinkedList<>();
    queue.add(0);
    queue.add(1);
    queue.add(1);

    while (queue.getFirst() + queue.get(1) + queue.getLast() <= n) {
      int sum = 0;

      for (int number : queue) {
        sum += number;
      }
      if (sum == n) {
        return true;
      }
      queue.removeFirst();
      queue.add(queue.getFirst() + queue.getLast());
    }
    return false;
  }

  public static void main(String[] args) {
    int n = 10_000_000;
    System.out.println(threeFibonacciSum(n));
  }
}
