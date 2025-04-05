import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  public static int[] productExceptSelf(int[] numbers) {
    int length = numbers.length;
    int[] prefixProduct = new int[length];
    int[] suffixProduct = new int[length];

    for (int i = 0; i < length; i++) {
      if (i == 0) {
        prefixProduct[i] = 1;
        continue;
      }
      prefixProduct[i] = numbers[i - 1] * prefixProduct[i - 1];
    }

    for (int i = length - 1; i >= 0; i--) {
      if (i == length - 1) {
        suffixProduct[i] = 1;
        continue;
      }
      suffixProduct[i] = numbers[i + 1] * suffixProduct[i + 1];
    }

    int[] answers = new int[length];

    for (int i = 0; i < length; i++) {
      answers[i] = prefixProduct[i] * suffixProduct[i];
    }
    return answers;
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4};
    int[] result = productExceptSelf(a);

    System.out.println(Arrays.toString(result));
  }
}
