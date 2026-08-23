public class NumberOfProvinces {

  public static int findCircleNum(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length];
    int count = 0;

    int n = isConnected.length;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        count++;
        dfs(i, visited, isConnected);
      }
    }
    return count;
  }

  public static void dfs(int curCity, boolean[] visited, int[][] isConnected) {
    for (int i = 0; i < isConnected[curCity].length; i++) {
      if (isConnected[curCity][i] == 1 && !visited[i]) {
        visited[i] = true;
        dfs(i, visited, isConnected);
      }
    }
  }

  public static void main(String[] args) {
    int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    System.out.println(findCircleNum(isConnected));
  }
}
