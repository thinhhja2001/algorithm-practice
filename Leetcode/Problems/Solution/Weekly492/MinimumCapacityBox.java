package Weekly492;

public class MinimumCapacityBox {

  public int minimumIndex(int[] capacity, int itemSize) {
    int index = -1;
    for (int i = 0; i < capacity.length; i++) {
      if (capacity[i] >= itemSize) {
        if (index == -1) {
          index = i;
          continue;
        }
        index = capacity[index] > capacity[i] ? i : index;
      }
    }
    return index;
  }

  void main() {
    int[] capacity = {3, 5, 4, 3};
    int itemSize = 2;
    System.out.println(minimumIndex(capacity, itemSize));
  }
}
