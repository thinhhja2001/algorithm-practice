import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GoodNodes {


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


  public static int goodNodes(TreeNode nodes) {
    Map<TreeNode, List<Integer>> treeNodeListMap = new HashMap<>();
    Map<TreeNode, Boolean> treeNodeBooleanMap = new HashMap<>();
    List<Integer> initialValue = new ArrayList<>();
    initialValue.add(nodes.val);
    treeNodeListMap.put(nodes, initialValue);
    treeNodeBooleanMap.put(nodes, true);

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(nodes);
    while (!queue.isEmpty()) {
      TreeNode curNode = queue.poll();
      if (curNode == null) {
        continue;
      }
      TreeNode left = curNode.left;
      if (left != null) {
        queue.add(left);
        List<Integer> curList = new ArrayList<>(treeNodeListMap.get(curNode));
        curList.add(left.val);
        if (left.val < curNode.val) {
          treeNodeBooleanMap.put(left, false);
        } else {
          boolean curBool = treeNodeBooleanMap.get(curNode);
          if (curBool) {
            treeNodeBooleanMap.put(left, true);
          } else {
            Integer last = curList.getLast();
            for (Integer value : curList) {
              if (last < value) {
                treeNodeBooleanMap.put(left, false);
                break;
              }
            }
            treeNodeBooleanMap.putIfAbsent(left,true);
          }
        }
        treeNodeListMap.put(left, curList);
      }
      TreeNode right = curNode.right;
      if (curNode.right != null) {
        queue.add(right);
        List<Integer> curList = new ArrayList<>(treeNodeListMap.get(curNode));
        curList.add(right.val);
        if (right.val < curNode.val) {
          treeNodeBooleanMap.put(right, false);
        } else {
          boolean curBool = treeNodeBooleanMap.get(curNode);
          if (curBool) {
            treeNodeBooleanMap.put(right, true);
          } else {
            Integer last = curList.getLast();
            for (Integer value : curList) {
              if (last < value) {
                treeNodeBooleanMap.put(right, false);
                break;
              }
            }
            treeNodeBooleanMap.putIfAbsent(right, true);
          }
        }
        treeNodeListMap.put(right, curList);
      }
    }
    return (int) treeNodeBooleanMap.values().stream().filter(e -> e == true).count();
  }

  public static void printNode(TreeNode root) {
    List<Integer> arrList = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    arrList.add(root.val);
    Map<TreeNode, Boolean> nodeMap = new HashMap<>();
    nodeMap.put(root, true);
    while (!queue.isEmpty()) {
      TreeNode curNode = queue.poll();
      if (curNode == null) {
        continue;
      }
      if (curNode.left != null) {
        arrList.add(curNode.left.val);
        queue.add(curNode.left);
      } else {
        arrList.add(null);
      }
      if (curNode.right != null) {
        queue.add(curNode.right);
        arrList.add(curNode.right.val);

        nodeMap.put(curNode.right, false);
      } else {
        arrList.add(null);
      }

    }

    System.out.println(arrList);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(9);

    root.right= new TreeNode(3);
    root.right.left = new TreeNode(6);
//    root.right.right = new TreeNode(5);

//    printNode(root);
    System.out.println(goodNodes(root));
  }

}
