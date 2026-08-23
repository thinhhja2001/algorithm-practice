import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Queue<Integer> queue = new LinkedList<>(rooms.getFirst());

    boolean[] visitedRoom = new boolean[rooms.size()];
    visitedRoom[0] = true;
    while (!queue.isEmpty()) {
      Integer curKey = queue.poll();
      if (visitedRoom[curKey]) {
        continue;
      }
      visitedRoom[curKey] = true;
      queue.addAll(rooms.get(curKey));

    }

    for (boolean v : visitedRoom) {
      if (!v) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
    System.out.println(canVisitAllRooms(rooms));
  }
}
