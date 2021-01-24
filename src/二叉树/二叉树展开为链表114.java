package 二叉树;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2021/1/22 9:47
 */


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class 二叉树展开为链表114 {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode5;
        flatten(treeNode);
    }
    public static void flatten(TreeNode root) {
        TreeNode head = root;
        frontTravel(head, null);
        head = root;
        while (head != null){
//            System.out.print(root.val + " ");
            head.right = head.left;
            head.left = null;
        }
        System.out.print("end");
    }
    public static void frontTravel(TreeNode node, TreeNode lastNode){
        if (node != null){
            // 访问该节点
            if (lastNode != null) {
                lastNode.left = node;
            }
            lastNode = node;
            frontTravel(node.left, lastNode);
            frontTravel(node.right, lastNode);
        }
    }
}
