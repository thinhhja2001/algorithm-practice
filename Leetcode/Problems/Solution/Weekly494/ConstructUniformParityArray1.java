package Weekly494;

public class ConstructUniformParityArray1 {

  public static boolean uniformArray(int[] nums1) {
    int[] canEven = new int[nums1.length];
    int[] canOdd = new int[nums1.length];
    if (nums1.length == 1) {
      return true;
    }
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums1.length; j++) {
        if (i == j) {
          continue;
        }
        if (nums1[i] - nums1[j] % 2 == 0 || nums1[i] % 2 == 0) {
          canEven[i] = 1;
        }
        if (nums1[i] - nums1[j] % 2 != 0 || nums1[i] % 2 != 0) {
          canOdd[i] = 1;
        }
      }
    }
    int even = 1;
    int odd = 1;
    for (int i = 0; i < nums1.length; i++) {
      even *= canEven[i];
      odd *= canOdd[i];
    }
    return even == 1 || odd == 1;
  }

  public static void main(String[] args) {
    int[] nums1 = {2, 3};
    System.out.println(uniformArray(nums1));
  }
}
