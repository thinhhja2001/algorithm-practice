import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

  private class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int maxLevelSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int level = 0;
    int maxSum = Integer.MIN_VALUE;
    int maxLevel = 0;
    while (!queue.isEmpty()) {
      int curSum = 0;
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        TreeNode node = queue.poll();
        curSum += node.val;

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      if (curSum > maxSum) {
        maxSum = curSum;
        maxLevel = level;
      }
      level++;
    }
    return maxLevel + 1;
  }

  void main() {
    TreeNode root = new TreeNode(989);
    root.right = new TreeNode(10250);
    root.right.left = new TreeNode(98693);
    root.right.right = new TreeNode(-89388);
    root.right.right.right = new TreeNode(-32127);
    System.out.println(maxLevelSum(root));
  }
}
