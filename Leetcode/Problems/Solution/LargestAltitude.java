public class LargestAltitude {

  public static int largestAltitude(int[] gain) {
    int max = 0;
    int prefix = 0;
    for (int element : gain) {
      prefix += element;
      max = Math.max(max, prefix);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] gain = {-4, -3, -2, -1, 4, 3, 2};
    System.out.println(largestAltitude(gain));
  }
}
