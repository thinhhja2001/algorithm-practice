import java.util.List;

public static class ListNode {

  Integer val;
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

public static ListNode reverselinkedlist(ListNode head) {
  if (head == null || head.next == null) {
    return head;
  }
  ListNode prev = null;
  ListNode cur = head;
  while (cur != null) {
    ListNode next = cur.next;
    cur.next = prev;
    prev = cur;
    cur = next;
  }
  return prev;
}

public static void main(String[] args) {
  ListNode listNode = new ListNode();
  List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
  for (Integer integer : list) {
    insertNode(listNode, integer);
  }
  ListNode n = reverselinkedlist(listNode.next.next);
  while (listNode != null) {
    System.out.println(listNode.val);
    listNode = listNode.next;
  }
}
