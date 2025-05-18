import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

  public static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
      boolean shouldAddAsteroidToStack = true;
      while (!stack.isEmpty() && stack.lastElement() > 0 && asteroid < 0) {
        if (Math.abs(stack.lastElement()) > Math.abs(asteroid)) {
          shouldAddAsteroidToStack = false;
          break;
        } else if (Math.abs(stack.lastElement()) < Math.abs(asteroid)) {
          stack.pop();
        } else {
          stack.pop();
          shouldAddAsteroidToStack = false;
          break;
        }
      }
      if (shouldAddAsteroidToStack) {
        stack.push(asteroid);
      }
    }
    int[] result = new int[stack.size()];
    for (int i = 0; i < stack.size(); i++) {
      result[i] = stack.elementAt(i);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] asteroids = {-2, -1, 1, 2};
    System.out.println(Arrays.toString(asteroidCollision(asteroids)));
  }
}
