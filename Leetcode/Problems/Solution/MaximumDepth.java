import java.util.ArrayList;
import java.util.List;

public class MaximumDepth {

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

  public static void getLeafNodes(TreeNode root, List<Integer> list) {
    if (root != null && root.left == null && root.right == null) {
      list.add(root.val);
    }
    if (root == null) {
      return;
    }
    getLeafNodes(root.left, list);
    getLeafNodes(root.right, list);
  }

  public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer>list1 = new ArrayList<>();
    List<Integer>list2 = new ArrayList<>();

    getLeafNodes(root1,list1);
    getLeafNodes(root2,list2);

    return list1.equals(list2);
  }

  public static void main(String[] args) {

  }
}
