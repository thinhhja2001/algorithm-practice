public class WaterBottles {

  public static int maxBottlesDrunk(int numBottles, int numExchange) {
    int emptyBottles = 0;
    int countBottles = 0;
    while (numBottles != 0 || emptyBottles >= numExchange) {
      countBottles += numBottles;
      emptyBottles += numBottles;
      numBottles = 0;
      if (emptyBottles >= numExchange) {
        numBottles++;
        emptyBottles = emptyBottles - numExchange;
        numExchange++;
      }
    }
    return countBottles;
  }

  public static void main(String[] args) {
    System.out.println(maxBottlesDrunk(10, 3));
  }
}
