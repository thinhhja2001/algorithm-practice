import java.util.List;

public class PairSum {

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

  public static void reverseHalf(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode prev = null;
    ListNode cur = slow.next;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    slow.next = prev;
  }

  public static int pairSum(ListNode head) {
    reverseHalf(head);
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    slow = slow.next;
    int max = 0;
    while (slow != null) {
      if (head.val + slow.val > max) {
        max = head.val + slow.val;
      }
      slow = slow.next;
      head = head.next;
    }
    return max;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
    node.next.next.next.next.next = new ListNode(6);

    System.out.println(pairSum(node));
    System.out.println(node);
  }
}
