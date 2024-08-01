package com.wuzbre.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class The_Minimum_Depth_of_a_BinaryTree {

    public static int the_Minimum_Depth_of_a_BinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        int minDepth = 0;
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                if (node.left == null && node.right == null) return minDepth;
            }
            minDepth++;
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode b = new TreeNode(9);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(20, d, e);
        TreeNode a = new TreeNode(3, b, c);

        int i = the_Minimum_Depth_of_a_BinaryTree(a);
        System.out.println(i);
    }

}
