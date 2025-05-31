import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RecentCounterSolution {

  public static class RecentCounter {

    private List<Integer> queue;

    public RecentCounter() {
      queue = new LinkedList<>();
    }

    public int ping(int t) {
      int count = 0;
      for (Integer value : queue) {
        if (value >= t - 3000) {
          count++;
        }
      }
      count++;
      queue.add(t);
      return count;
    }
  }

  public static void main(String[] args) {
    RecentCounter recentCounter = new RecentCounter();
    List<Integer> ping = List.of(1, 100, 3001, 3002);
    for (int value : ping) {
      System.out.print(recentCounter.ping(value));
    }
  }
}
