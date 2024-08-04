package com.wuzbre.binarytree;

public class Balanced_BinaryTree {

    //递归法
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5,node8,node8);
        TreeNode node5 = new TreeNode(4,node8,node9);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node4 = new TreeNode(0);
        TreeNode node3 = new TreeNode(8,node6,node7);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(6,node2,node3);

        boolean balanced = isBalanced(node1);
        System.out.println(balanced);

    }
}
