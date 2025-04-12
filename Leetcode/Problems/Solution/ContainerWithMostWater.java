public class ContainerWithMostWater {

  public static int calculateArea(int[] height, int left, int right) {
    return Math.min(height[left], height[right]) * (right - left);
  }

  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left < right) {
      int area = calculateArea(height, left, right);
      if (area > max) {
        max = area;
      }
      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }
    return max;
  }


  public static void main(String[] args) {
    int[] height = new int[]{1, 3, 2, 5, 25, 24, 5};
    System.out.println(maxArea(height));
  }
}
