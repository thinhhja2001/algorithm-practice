import java.util.PriorityQueue;

public class MaxAverageRatio {

  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
      Double gainA = ((double) a[0] + 1) / (a[1] + 1) - ((double) a[0] / a[1]);
      Double gainB = ((double) b[0] + 1) / (b[1] + 1) - ((double) b[0] / b[1]);
      return gainB.compareTo(gainA);
    });

    for (int[] clazz : classes) {
      pq.add(new int[]{clazz[0], clazz[1]});
    }

    while (extraStudents > 0) {
      int[] current = pq.poll();
      pq.add(new int[]{current[0] + 1, current[1] + 1});
      extraStudents--;
    }

    Double val = 0D;

    while(!pq.isEmpty()){
      int []current = pq.poll();
      val+=((double) current[0] /current[1]);
    }

    return val / classes.length;
  }

  public void main(String[] args) {
    int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
    int extraStudents = 4;
    System.out.println(maxAverageRatio(classes, extraStudents));
  }
}
