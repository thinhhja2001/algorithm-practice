package Weekly494;


public class ConstructUniformParityArray2 {

  public static boolean uniformArray(int[] nums1) {
    int even=1;
    int odd=1;

    int minOdd = Integer.MAX_VALUE;
    for (int i = 0; i < nums1.length; i++) {
      if (nums1[i] % 2 != 0) {
        minOdd = Math.min(minOdd, nums1[i]);
      }
    }

    for (int i = 0; i < nums1.length; i++) {
      int canEven=0;
      int canOdd=0;
      if (nums1[i] % 2 == 0) {
        canEven = 1;
      }
      if (nums1[i] % 2 != 0) {
        canOdd = 1;
      }
      if (nums1[i] % 2 == 0 && minOdd != Integer.MAX_VALUE && nums1[i] - minOdd >= 0) {
        canOdd = 1;
      }
      if (nums1[i] % 2 != 0 && minOdd != nums1[i]) {
        canEven = 1;
      }
      even*=canEven;
      odd*=canOdd;
    }
    return even == 1 || odd == 1;
  }

  public static void main(String[] args) {
    int[] arr = {3};
    System.out.println(uniformArray(arr));
  }
}
