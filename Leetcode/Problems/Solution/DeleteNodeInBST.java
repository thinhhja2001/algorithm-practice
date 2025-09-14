import org.w3c.dom.Node;

public class DeleteNodeInBST {

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

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        TreeNode suc = getSuccessor(root);
        int temp = root.val;
        root.val = suc.val;
        suc.val = temp;
        root.right = deleteNode(root.right, temp);
      }
    }
    return root;
  }

  public TreeNode getSuccessor(TreeNode root) {
    TreeNode suc = root.right;
    while (suc != null && suc.left != null) {
      suc = suc.left;
    }
    return suc;
  }

  void main() {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(40);
    root.right = new TreeNode(70);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(80);

    deleteNode(root, 50);
  }
}
