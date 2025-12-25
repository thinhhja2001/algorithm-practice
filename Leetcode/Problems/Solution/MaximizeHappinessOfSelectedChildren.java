import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

  public long maximumHappinessSum(int[] happiness, int k) {
    happiness = Arrays.stream(happiness).sorted().toArray();

    int index = happiness.length - 1;
    long start = 0;
    long sum = 0;
    while (start < k) {
      if (happiness[index] - start < 0) {
        break;
      }
      sum += happiness[index] - start;
      index--;
      start++;
    }

    return sum;
  }

  void main() {
    int[] happiness = {1, 1, 1, 1};
    int k = 2;
    System.out.println(maximumHappinessSum(happiness, k));
  }
}
