import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

  static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static int nearestExit(char[][] maze, int[] entrance) {
    Queue<int[]> queue = new LinkedList<>();
    int count = 0;

    queue.offer(entrance);
    maze[entrance[0]][entrance[1]] = '+';
    while (!queue.isEmpty()) {
      count++;
      int n = queue.size();

      for (int i = 0; i < n; i++) {
        int[] pos = queue.poll();
        if (pos == null) {
          break;
        }
        for (int[] direction : directions) {
          int x = pos[0] + direction[0];
          int y = pos[1] + direction[1];
          if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            continue;
          }
          if (maze[x][y] == '+') {
            continue;
          }
          if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1) {
            return count;
          }
          maze[x][y] = '+';
          queue.offer(new int[]{x, y});
        }
      }

    }
    return -1;
  }

  public static int nearestExitDFS(char[][] maze, int[] entrance) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int x = entrance[0];
    int y = entrance[1];
    visited[x][y] = true;

    for (int[] direction : directions) {
      int[] pos = new int[]{x + direction[0], y + direction[1]};
      if (isValidPos(visited, pos, maze)) {
        int val = search(visited, pos, entrance, maze);
        if (val != -1) {
          pq.add(1 + val);
        }
      }
    }
    return pq.isEmpty() ? -1 : pq.poll();
  }

  public static boolean isValidPos(boolean[][] visited, int[] pos, char[][] maze) {
    int x = pos[0];
    int y = pos[1];
    return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && !visited[x][y] && maze[x][y] == '.';
  }

  public static int search(boolean[][] visited, int[] currentPos, int[] entrance, char[][] maze) {
    int x = currentPos[0];
    int y = currentPos[1];
    if (x < 0 || y < 0) {
      return -1;
    }
    if (x >= maze.length || y >= maze[0].length) {
      return -1;
    }
    if (maze[x][y] == '+') {
      return -1;
    }
    if (x == entrance[0] && y == entrance[1]) {
      return -1;
    }
    if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) {
      return 0;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    visited[x][y] = true;
    for (int[] direction : directions) {
      int[] pos = new int[]{currentPos[0] + direction[0], currentPos[1] + direction[1]};

      int val = isValidPos(visited, pos, maze)
          ? search(visited, pos, entrance, maze)
          : -1;
      visited[pos[0]][pos[1]] = true;
      if (val != -1) {
        pq.add(1 + val);
      }
    }
    return pq.isEmpty() ? -1 : pq.poll();
  }

  public static void main(String[] args) {
    char[][] maze = new char[][]
        {
            {'+', '.', '+', '+', '+', '+', '+'},
            {'+', '.', '+', '.', '.', '.', '+'},
            {'+', '.', '+', '.', '+', '.', '+'},
            {'+', '.', '.', '.', '+', '.', '+'},
            {'+', '+', '+', '+', '+', '.', '+'}};
    int[] entrance = new int[]{3, 2};
    System.out.println(nearestExit(maze, entrance));
  }
}
