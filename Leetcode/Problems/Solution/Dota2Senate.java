import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
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
    Queue<Integer> rQueue = new LinkedList<>();
    Queue<Integer> dQueue = new LinkedList<>();
    for (int i = 0; i < senate.length(); i++) {
      if (senate.charAt(i) == 'R') {
        rQueue.add(i);
      } else {
        dQueue.add(i);
      }
    }

    while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
      int rIndex = rQueue.poll();
      int dIndex = dQueue.poll();

      if (rIndex < dIndex) {
        rQueue.add(rIndex + senate.length());
      } else {
        dQueue.add(dIndex + senate.length());
      }
    }
    if(dQueue.isEmpty())  return "Radiant";
    return "Dire";
  }

  public static void main(String[] args) {
    String senate = "RD";
    System.out.println(predictPartyVictory(senate));
  }
}
