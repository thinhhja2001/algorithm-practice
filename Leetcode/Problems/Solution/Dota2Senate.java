import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class Dota2Senate {

  public static Character removeNextSenate(Queue<Character> queue, Character currentSenate) {
    Character target;
    if (currentSenate == 'D') {
      target = 'R';
    } else {
      target = 'D';
    }
    Iterator<Character> it = queue.iterator();
    while (it.hasNext()) {
      Character c = it.next();
      if (c.equals(target)) {
        it.remove();
        return null;
      }
    }
    return currentSenate;
  }

  public static String predictPartyVictory(String senate) {
    Queue<Character> queue = new ArrayDeque<>();
    for (Character c : senate.toCharArray()) {
      queue.add(c);
    }
    while (true) {
      Character currentSenate = queue.poll();
      queue.add(currentSenate);
      Character c = removeNextSenate(queue, currentSenate);
      if (c != null) {
        break;
      }
    }
    return removeNextSenate(queue, queue.peek()) == 'R' ? "Radiant" : "Dire";
  }

  public static void main(String[] args) {
    String senate = "RRDDRRRDDRDDRRDDRDRDDDDDRDDRRRRRRRDRDDRRDRDRDRRRDDDRRDRRRDRRDRDDDDDDDDRRRDDDRDDRRDRRDRDRRRDDDDRRRDRRRRRDRRDRRDRRRDDRRRDRRRRRDRRRRDDDRRRDRDDRRDDRDRDRDRDDRDRDRRRDRRRDRRDRDDDRDRDDRDDDDRRRRDRRDRDRDRDRDRDDRDRDRDDDRRRRRDDDDDDDRRRRDRRDRDDDRDRDDDRRRRDRDRDDDDRDDRDDRRDDRRDRRRRRDRDDRDRRDDRRRDRRRRDDRRRRDDDRRDDRRRRDRRRDRRRRDDRRDDRRRDRDDDDRDDRRRDDDRDRDDRRDDRRRRRRDDRDDDDDDDRDRRDDDDRDDRRRDRRRDRDDRRRDRDDRDRRRRDRRDDDDDDRDDDRRRRRRRRDRDDDDDRDRRRRRDDRDDRRDRDDDDDDRRRDRRRDDRDRRDDRRDRDRDDRRDDRDDRRDDDRRRDDDDRRDRDDRDRDRDDDRRRRRDDDRDDDRDRRDDRRRRDRRDRRRRRDDDDRRRRRRDRRDRDDDDRRDRDDDRDDRRDRRRRDRRDDDRRRDDDRDRDRDRDDRDDDDDRRDDRRRRDDDDDRRRRDRDRDRRRDDRRRDDRRDDRDDRDRRRDRDRRRDRDRDDRRDDDDRRRRDDDRRRDDRDDDRDRRDRRRRDDRRRRDDDDDDRRDDDRDR";
    System.out.println(predictPartyVictory(senate));
  }
}
