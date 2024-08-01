package com.wuzbre.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class The_Maximum_Depth_of_a_BinaryTree {

    public static int the_Maximum_Depth_of_a_BinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        int maxDepth = 0;
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode b = new TreeNode(9);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(20, d, e);
        TreeNode a = new TreeNode(3, b, c);

        int i = the_Maximum_Depth_of_a_BinaryTree(a);
        System.out.println(i);
    }

}
