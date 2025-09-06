import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

  public List<Integer> rightSideView(TreeNode root) {
    if(root==null){
      return  new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 0;
    while (!queue.isEmpty()) {
      int len = queue.size();
      result.add(new ArrayList<>());
      for (int i = 0; i < len; i++) {
        TreeNode node = queue.poll();
        result.get(level).add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      level++;
    }
    return result.stream().map(List::getLast).toList();

  }

  void main() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);

    List<Integer>result = rightSideView(root);
    System.out.println(result);
  }
}
