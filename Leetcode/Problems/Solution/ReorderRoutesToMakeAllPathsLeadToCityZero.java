import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ReorderRoutesToMakeAllPathsLeadToCityZero {


  public static int minReorder(int n, int[][] connections) {
    List<Set<Integer>> nonDirectedConnection = new ArrayList<>(n);
    List<Set<Integer>> directedConnection = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      nonDirectedConnection.add(new HashSet<>());
      directedConnection.add(new HashSet<>());
    }
    for (int[] connection : connections) {
      directedConnection.get(connection[0]).add(connection[1]);
      nonDirectedConnection.get(connection[0]).add(connection[1]);
      nonDirectedConnection.get(connection[1]).add(connection[0]);
    }
    boolean[] visited = new boolean[n];
    int count = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    while (!queue.isEmpty()) {
      int start = queue.poll();
      for (int target : nonDirectedConnection.get(start)) {
        if(!visited[target]){
          queue.offer(target);
          if(directedConnection.get(start).contains(target)){
            count++;
          }
        }
      }
      visited[start] = true;
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] connections = {{1,0},{2,0}};
    System.out.println(minReorder(3, connections));
  }
}
