package Weekly511;

public class EvenNumberKnightOfMoves {

  int[][] DIRECTIONS = new int[][]{{3, 3}, {1, 2}, {2, 1}};

  public static boolean canReach(int[] start, int[] target) {
    return ((start[0] + start[1]) % 2) == ((target[0] + target[1]) % 2);
  }

  public static void main(String[] args) {
  }
}
