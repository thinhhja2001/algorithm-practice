package Weekly511;

import java.util.Arrays;

public class TransformBinaryStringUsingSubsequentSort {

  public static boolean transformAble(String a, String b) {

    char[] s1 = a.toCharArray();
    char[] s2 = b.toCharArray();
    int count_1_s1 = 0;
    int count_0_s1 = 0;

    for (int i = 0; i < s1.length; i++) {
      if (s1[i] == '1') {
        count_1_s1++;
      }
      if (s1[i] == '0') {
        count_0_s1++;
      }
    }

    int count_1_s2 = 0;
    int count_0_s2 = 0;
    int count___s2 = 0;

    for (int i = 0; i < s2.length; i++) {
      if (s2[i] == '1') {
        count_1_s2++;
      }
      if (s2[i] == '0') {
        count_0_s2++;
      }
      if (s2[i] == '?') {
        count___s2++;
      }
    }

    if (count_1_s2 > count_1_s1 || count_0_s2 > count_0_s1) {
      return false;
    }

    int i = s2.length - 1;
    while (i >= 0 && count_1_s2 < count_1_s1) {
      if (s2[i] == '?') {
        s2[i] = '1';
        count_1_s2++;
      }
      i--;
    }

    while (i >= 0) {
      if (s2[i] == '?') {
        s2[i] = '0';
      }
      i--;
    }

    int[] s1_0 = new int[s1.length];
    s1_0[0] = s1[0] == '0' ? 1 : 0;
    int[] s2_0 = new int[s2.length];
    s2_0[0] = s2[0] == '0' ? 1 : 0;

    if (s1_0[0] > s2_0[0]) {
      return false;
    }

    for (int j = 1; j < s1.length; j++) {
      s1_0[j] = s1[j] == '0' ? 1 + s1_0[j - 1] : s1_0[j - 1];
      s2_0[j] = s2[j] == '0' ? 1 + s2_0[j - 1] : s2_0[j - 1];

      if (s1_0[j] > s2_0[j]) {
        return false;
      }
    }
    return true;
  }

  public static boolean[] transformStr(String s, String[] strs) {
    boolean[] result = new boolean[strs.length];
    for (int i = 0; i < strs.length; i++) {
      if (transformAble(s, strs[i])) {
        result[i] = true;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String s = "101";
    String[] strs = new String[]{"1?1", "0?1", "0?0"};
    System.out.println(Arrays.toString(transformStr(s, strs)));
  }
}
