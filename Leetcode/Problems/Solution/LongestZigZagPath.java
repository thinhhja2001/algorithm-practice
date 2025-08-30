public class LongestZigZagPath {

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

  public void getZigzagValue(TreeNode node, String curDirection, String prevDirection, int zigzagValue) {
    if (node == null) {
      return;
    }
    if (prevDirection == null) {
      node.val = zigzagValue + 1;
    } else if (curDirection.equals(prevDirection)) {
      node.val = 1;
    } else {
      node.val = zigzagValue + 1;
    }
    getZigzagValue(node.left, "left", curDirection, node.val);
    getZigzagValue(node.right, "right", curDirection, node.val);
  }

  int findMaxValue(TreeNode node) {
    if (node == null) {
      return Integer.MIN_VALUE;
    }
    int res = node.val;
    int lMax = findMaxValue(node.left);
    int rMax = findMaxValue(node.right);

    return Math.max(res, Math.max(lMax, rMax));
  }

  public int longestZigZag(TreeNode root) {
    int zigzagValue = 0;
    root.val = zigzagValue;
    getZigzagValue(root.left, "left", null, zigzagValue);
    getZigzagValue(root.right, "right", null, zigzagValue);

    return findMaxValue(root);
  }

  void main() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(9);
    root.right=new TreeNode(7);
    root.left.left=new TreeNode(3);
    root.right.left=new TreeNode(2);
    root.right.right=new TreeNode(8);
    root.left.left.left=new TreeNode(5);
    root.left.left.right=new TreeNode(8);
    System.out.println(longestZigZag(root));
  }
}
