package Weekly511;

public class CountDominantNodesInBinaryTree {

  public static int findMax(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.val;
    }
    if (root.left == null) {
      return Math.max(root.val, findMax(root.right));
    }
    if (root.right == null) {
      return Math.max(root.val, findMax(root.left));
    }
    int maxLeft = findMax(root.left);
    int maxRight = findMax(root.right);
    return Math.max(root.val, Math.max(maxLeft, maxRight));
  }

  public static boolean isDominant(TreeNode root) {
    if (root.left == null && root.right == null) {
      return true;
    }
    return findMax(root) == root.val;
  }

  public static int countDominantNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (isDominant(root)) {
      return 1 + countDominantNodes(root.left) + countDominantNodes(root.right);
    }
    return countDominantNodes(root.left) + countDominantNodes(root.right);
  }

  public static class TreeNode {

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

  public static void main(String[] args) {
    TreeNode node = new TreeNode(5);
    node.left = new TreeNode(3);
    node.right = new TreeNode(8);
    node.left.left = new TreeNode(2);
    node.left.right = new TreeNode(4);
    node.right.left = new TreeNode(7);
    node.right.right = new TreeNode(1);
    System.out.println(countDominantNodes(node));
  }
}
