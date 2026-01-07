import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumProductOfSplittedBinaryTree {
  public class TreeNode {

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

  public int sumOfTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    root.val = root.val + sumOfTree(root.left) + sumOfTree(root.right);
    return root.val;
  }

  public int maxProduct(TreeNode root) {
    long treeSum = sumOfTree(root);
    long max = 0;
    long mod = (int) 1e9 + 7;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode subTree = queue.poll();
      long subTreeSum = treeSum - subTree.val;
      max = Math.max(max, (treeSum - subTreeSum) * subTreeSum);
      if (subTree.left != null) {
        queue.offer(subTree.left);
      }
      if (subTree.right != null) {
        queue.offer(subTree.right);
      }
    }
    return (int) (max % mod);
  }

  void main() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    treeNode.right.left = new TreeNode(3);
    treeNode.right.right = new TreeNode(4);
    treeNode.right.right.left = new TreeNode(5);
    treeNode.right.right.right = new TreeNode(6);
    System.out.println(maxProduct(treeNode));
  }
}
