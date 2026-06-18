public class AngleBetweenHandsOfClock {

  public static double angleClock(int hour, int minutes) {
    double MIN_DEGREE = 6;
    double HOUR_DEGREE = 30;

    double minuteDegree = minutes * MIN_DEGREE;

    double hourDegree = hour * HOUR_DEGREE + (minutes * HOUR_DEGREE) / 60;

    double degree = Math.abs(hourDegree - minuteDegree);
    return Math.min(360 - degree, degree);
  }

  public static void main(String[] args) {
    System.out.println(angleClock(1, 4));
  }
}
