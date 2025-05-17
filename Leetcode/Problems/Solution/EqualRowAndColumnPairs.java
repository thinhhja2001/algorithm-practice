import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualRowAndColumnPairs {

  public static int equalPairs(int[][] grid) {
    Map<String, Integer> rowMapper = new HashMap<>();
    Map<String, Integer> colMapper = new HashMap<>();
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < col; j++) {
        builder.append(grid[i][j]).append(" ");
        if (j == col - 1) {
          String key = builder.toString();
          Integer value = rowMapper.getOrDefault(key, 0);
          rowMapper.put(key, value + 1);
        }
      }
    }
    for (int i = 0; i < col; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < row; j++) {
        builder.append(grid[j][i]).append(" ");
        if (j == row - 1) {
          String key = builder.toString();
          Integer value = colMapper.getOrDefault(key, 0);
          colMapper.put(key, value + 1);
        }
      }
    }
    int count = 0;
//    System.out.println(rowMapper);
//    System.out.println(colMapper);
    for (String k : rowMapper.keySet()) {
      Integer rowVal = rowMapper.get(k);
      Integer colVal = colMapper.get(k);
      if (Objects.nonNull(rowVal) && Objects.nonNull(colVal)) {
        count += rowVal * colVal;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] grid = {{11, 1}, {1, 11}};
    System.out.println(equalPairs(grid));
  }
}
