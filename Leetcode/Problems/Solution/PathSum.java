import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PathSum {

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

  public static int pathSum(TreeNode tree, int targetSum, List<Long> sumList) {
    if (tree == null) {
      return 0;
    }
    List<Long> list = new ArrayList<>(sumList);
    list.replaceAll(integer -> integer + tree.val);
    list.add((long) tree.val);
    int count = 0;
    for (Long x : list) {
      count += x == targetSum ? 1 : 0;
    }

    return count + pathSum(tree.left, targetSum, list) + pathSum(tree.right, targetSum, list);
  }

  public static int pathSum(TreeNode root, int targetSum) {
    return pathSum(root, targetSum, new ArrayList<>());
  }

  static void main(String[] args) {
    TreeNode root = new TreeNode(1000000000);
    root.left = new TreeNode(1000000000);
    root.left.left = new TreeNode(294967296);
    root.left.left.left = new TreeNode(1000000000);
    root.left.left.left.left = new TreeNode(1000000000);
    root.left.left.left.left.left = new TreeNode(1000000000);
    int targetSum = 0;
    System.out.println(pathSum(root, targetSum));
  }
}
