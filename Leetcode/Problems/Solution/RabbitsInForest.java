import java.util.HashMap;

public class RabbitsInForest {

  public int numRabbits(int[] answers) {
    int minRabbit = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < answers.length; i++) {
      int key = answers[i] + 1;
      map.putIfAbsent(key, 0);

      int val = map.get(key) + 1;
      if (val > key) {
        minRabbit += key;
        map.put(key, 1);
      } else {
        map.put(key, val);
      }
    }
    for (int key : map.keySet()) {
      minRabbit += key;
    }
    return minRabbit;
  }

  public void main(String[] args) {
    int[] answers = {0,0,0};
    System.out.println(numRabbits(answers));
  }
}
