public class WeightedWordMapping {

  public static String mapWordWeights(String[] words, int[] weights) {
    StringBuilder sb = new StringBuilder(words.length);
    for (String word : words) {
      int sum = 0;
      for (Character ch : word.toCharArray()) {
        int index = ch - 'a';
        sum += weights[index];
      }
      sb.append((char) (122 - sum % 26));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] words = {"abcd"};
    int[] weights = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
    System.out.println(mapWordWeights(words, weights));
  }
}
