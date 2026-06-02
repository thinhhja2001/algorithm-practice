public class EarliestFinishTimeForLandAndWaterRise {

  public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime,
      int[] waterDuration) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < landStartTime.length; i++) {
      int startTime = landStartTime[i];
      int endTime = startTime + landDuration[i];
      for (int j = 0; j < waterStartTime.length; j++) {
        int waterStart = waterStartTime[j] - endTime >= 0 ? waterStartTime[j] : endTime;
        int waterEnd = waterStart + waterDuration[j];
        min = Math.min(min, waterEnd);
      }
    }

    for (int i = 0; i < waterStartTime.length; i++) {
      int startTime = waterStartTime[i];
      int endTime = startTime + waterDuration[i];
      for (int j = 0; j < landDuration.length; j++) {
        int waterStart = landStartTime[j] - endTime >= 0 ? landStartTime[j] : endTime;
        int waterEnd = waterStart + landDuration[j];
        min = Math.min(min, waterEnd);
      }
    }
    return min;
  }

  public static void main(String[] args) {

  }
}
