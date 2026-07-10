public class MinLightToIlluminateTheRoad {

  public static int minLights(int[] lights) {
    int[] arr = new int[lights.length + 1];
    for (int i = 0; i < lights.length; i++) {
      int light = lights[i];
      if (light > 0) {
        int start = Math.max(0, i - light);
        int end = Math.min(lights.length - 1, i + light);
        arr[start]++;
        arr[end + 1]--;
      }
    }

    int[] visit = new int[lights.length];
    int cur = 0;
    for (int i = 0; i < lights.length; i++) {
      cur += arr[i];
      visit[i] = cur;
    }
    int count = 0;
    int i = 0;
    while (i < lights.length) {
      if (visit[i] > 0) {
        i++;
      } else {
        count++;
        i += 3;
      }
    }
    return count;
  }


  public static void main(String[] args) {
    int[] lights = {0, 0, 2, 0, 0};
    System.out.println(minLights(lights));
  }
}
