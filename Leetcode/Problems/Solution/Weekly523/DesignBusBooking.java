package Weekly523;

import java.util.Arrays;

public class DesignBusBooking {

  static class BusBooking {

    int[] a;
    int[] b;
    int[] c;
    int[] d;

    int currentTime = 0;

    int minTime = 0;

    int size;

    public BusBooking(int n) {
      a = new int[n + 1];
      b = new int[n + 1];
      c = new int[n + 1];
      d = new int[n + 1];

      size = n + 1;

      Arrays.fill(a, 0);
      Arrays.fill(b, 0);
      Arrays.fill(c, 0);
      Arrays.fill(d, 0);
    }

    public void toggle(String seat) {
      char tier = seat.charAt(0);
      int number = Integer.parseInt(seat.substring(1));
      switch (tier) {
        case 'A':
          if (a[number] != 0) {
            currentTime -= a[number];
            minTime--;
            a[number] = 0;
          } else {
            a[number] = b[number] != 0 ? 3 : 1;
            currentTime += a[number];
            minTime++;
          }
          break;
        case 'B':
          if (b[number] != 0) {
            currentTime -= b[number];
            b[number] = 0;
            minTime--;
          } else {
            b[number] = 1;
            currentTime += b[number];
            minTime++;
          }
          break;
        case 'C':
          if (c[number] != 0) {
            currentTime -= c[number];
            minTime--;
            c[number] = 0;
          } else {
            c[number] = 1;
            currentTime += c[number];
            minTime++;
          }
          break;
        case 'D':
          if (d[number] != 0) {
            currentTime -= d[number];
            minTime--;
            d[number] = 0;
          } else {
            d[number] = c[number] != 0 ? 3 : 1;
            currentTime += d[number];
            minTime++;
          }
          break;
      }
    }

    public int getTotalTime() {
      return currentTime;
    }

    public int getMinTime() {
      return minTime;
    }
  }

  /**
   * Your BusBooking object will be instantiated and called as such:
   * BusBooking obj = new BusBooking(n);
   * obj.toggle(seat);
   * int param_2 = obj.getTotalTime();
   * int param_3 = obj.getMinTime();
   */

  public static void main(String[] args) {
    BusBooking bb = new BusBooking(1);
    bb.toggle("D1");
    bb.toggle("C1");
    System.out.println(bb.getMinTime());
    bb.toggle("D1");
    System.out.println(bb.getTotalTime());

  }
}
