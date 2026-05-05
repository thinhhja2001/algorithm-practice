import java.util.List;
import java.util.Stack;

public class RotatedDigits {

  public static int rotatedDigits(int n) {
    List<Integer> rotateToNewNum = List.of(2, 5, 6, 9);

    if (n <= 10) {
      return Math.toIntExact(rotateToNewNum.stream().filter(e -> e <= n).count());
    }

    List<Integer> rotateable = List.of(0, 1, 2, 5, 6, 8, 9);

    Stack<Integer> stack = new Stack<>();
    stack.addAll(rotateable);

    boolean[] rotatableArray = new boolean[n + 1];
    while (!stack.isEmpty()) {
      int num = stack.pop();
      rotatableArray[num] = true;
      for (Integer element : rotateable) {
        int newNum = num * 10 + element;
        if (num != newNum && newNum <= n) {
          stack.add(newNum);
        }
      }
    }

    boolean[] result = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      if (rotatableArray[i]) {
        for (Integer element : rotateToNewNum) {
          int newNum = i * 10 + element;
          if (newNum <= n) {
            result[newNum] = true;
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      if (result[i]) {
        for (Integer element : rotateable) {
          int newNum = i * 10 + element;
          if (newNum <= n) {
            result[newNum] = true;
          }
        }
      }
    }

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (result[i]) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int n = 857;
    System.out.println(rotatedDigits(n));
  }
}
