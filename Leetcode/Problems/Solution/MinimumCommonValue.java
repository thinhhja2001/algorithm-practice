public class MinimumCommonValue {

  public static int getCommon(int[] nums1, int[] nums2) {
    int left_1 = 0;
    int left_2 = 0;

    while (left_1 < nums1.length && left_2 < nums2.length) {
      if (nums1[left_1] < nums2[left_2]) {
        left_1++;
        continue;
      }
      if (nums1[left_1] > nums2[left_2]) {
        left_2++;
        continue;
      }
      if (nums1[left_1] == nums2[left_2]) {
        return nums1[left_1];
      }
    }
    while (left_1 < nums1.length) {
      if (nums1[left_1] == nums2[left_2 - 1]) {
        return nums1[left_1];
      }
      left_1++;
    }
    while (left_2 < nums2.length) {
      if (nums2[left_2] == nums1[left_1 - 1]) {
        return nums2[left_2];
      }
      left_2++;
    }
    return -1;
  }

  public static void main(String[] args) {

  }
}
