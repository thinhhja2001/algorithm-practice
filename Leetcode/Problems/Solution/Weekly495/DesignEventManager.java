package Weekly495;

import java.util.PriorityQueue;

import java.util.*;

public class DesignEventManager {


  static class EventManager {

    class Event {

      int id;
      int priority;

      public Event(int id, int priority) {
        this.id = id;
        this.priority = priority;
      }
    }

    PriorityQueue<Event> priorityQueue;
    Map<Integer, Integer> map = new HashMap<>();

    public EventManager(int[][] events) {
      priorityQueue = new PriorityQueue<>((a, b) -> {
        if (a.priority - b.priority != 0) {
          return -1 * (a.priority - b.priority);
        }
        return a.id - b.id;
      });
      for (int[] event : events) {
        int id = event[0];
        int priority = event[1];
        map.put(id, priority);
        priorityQueue.add(new Event(id, priority));
      }
    }

    public void updatePriority(int eventId, int newPriority) {
      map.put(eventId, newPriority);
      priorityQueue.add(new Event(eventId, newPriority));
    }

    public int pollHighest() {
      while (!map.isEmpty()) {
        Event e = priorityQueue.poll();
        if (e != null && map.get(e.id) != null && e.priority == map.get(e.id)) {
          map.remove(e.id);
          return e.id;
        }
      }
      return -1;
    }
  }

  public static void main(String[] args) {
    int[][] value = {{7, 8}, {4, 10}};
    EventManager ev = new EventManager(value);

    ev.updatePriority(4, 7);
    ev.updatePriority(7, 9);
    ev.updatePriority(4, 9);
    ev.updatePriority(4, 1);
    ev.updatePriority(4, 7);

    System.out.println(ev.pollHighest());
  }

}
