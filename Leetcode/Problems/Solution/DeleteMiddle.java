import java.util.List;

public class DeleteMiddle {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode deleteMiddle(ListNode head) {
    ListNode slow = head;
    ListNode prev = slow;
    ListNode fast = head;
    if (head.next == null) {
      return null;
    }
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      prev = slow;
      slow = slow.next;
    }
    prev.next = slow.next;
    return head;
  }

  public static void insertNode(ListNode l, int value) {
    if (l == null) {
      return;
    }
    ListNode temp = l;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new ListNode(value);
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode();
    List<Integer> list = List.of(1, 3, 4, 7, 1, 2, 6);
    for (Integer integer : list) {
      insertNode(listNode, integer);
    }
    while (listNode.next != null) {
      listNode = listNode.next;
      System.out.println(listNode.val);
    }
  }

}
