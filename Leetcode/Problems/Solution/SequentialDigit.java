import java.util.LinkedList;
import java.util.List;

public class SequentialDigit {

  public static List<Integer> sequentialDigits(int low, int high) {
    int curSeq = 12;
    int add = 11;

    List<Integer> result = new LinkedList<>();
    while (curSeq <= high) {
      for (int i = curSeq; ; i += add) {
        if (i % 10 < curSeq % 10) {
          break;
        }
        if (i > high) {
          return result;
        }
        if (i >= low) {
          result.add(i);
        }
      }
      add = add * 10 + 1;
      curSeq = curSeq + add;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(sequentialDigits(123, 123456789));
  }
}
