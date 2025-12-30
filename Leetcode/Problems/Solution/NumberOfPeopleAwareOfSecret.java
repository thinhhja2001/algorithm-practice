import java.util.Arrays;

public class NumberOfPeopleAwareOfSecret {

  public int peopleAwareOfSecret(int n, int delay, int forget) {
    int MODULO = (int) 1e9 + 7;
    int[] newPeoplePerDay = new int[2 * n + 10];
    int[] peopleKnowingSecret = new int[2 * n + 10];

    newPeoplePerDay[0] = 1;

    for (int i = 0; i < n; i++) {
        peopleKnowingSecret[i] = (peopleKnowingSecret[i] + newPeoplePerDay[i]) % MODULO;

        peopleKnowingSecret[i + forget] =
            (peopleKnowingSecret[i + forget] - newPeoplePerDay[i] + MODULO) % MODULO;

        int shareStartDay = i + delay;
        while (shareStartDay < i + forget) {
          newPeoplePerDay[shareStartDay] = (newPeoplePerDay[shareStartDay] + newPeoplePerDay[i]) % MODULO;
          shareStartDay++;
        }

    }

    long totalPeople = 0;
    for (int i = 0; i < n; i++) {
      totalPeople = (totalPeople + peopleKnowingSecret[i]) % MODULO;
    }
    return (int) totalPeople;
  }

  void main() {
    System.out.println(peopleAwareOfSecret(684, 18, 496));
  }
}
