import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodeFromLinkedList {

  public class ListNode {

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

  // 3 -> 4 -> 5
  public ListNode deleteNode(ListNode prev, ListNode current) {
    if (prev == null) {
      return current.next;
    } else {
      prev.next = current.next;
      return prev;
    }
  }

  public ListNode modifiedList(List<Integer> nums, ListNode head) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    while (head != null && set.contains(head.val)) {
      head = head.next;
    }

    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      if (set.contains(current.val)) {
        current = deleteNode(prev, current);
      }
      prev = current;
      current = current.next;
    }
    return head;
  }

  void main() {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(1);
    node.next.next.next.next.next = new ListNode(2);

    node = modifiedList(List.of(5), node);
    printListNode(node);
  }

  public void printListNode(ListNode node) {
    while (node != null) {
      System.out.print(node.val + "\t");
      node = node.next;
    }
    System.out.println();
  }
}
