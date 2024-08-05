package com.wuzbre.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Find_the_value_in_the_lower_left_corner_of_the_tree {

    public static int find_the_value_in_the_lower_left_corner_of_the_tree(TreeNode root) {

        int value = 0;
        Queue<TreeNode> que = new LinkedList<>();

        if (root == null) return 0;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                value = node.val;
            }
        }
        return value;
    }


    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7, node6, null);
        TreeNode node4 = new TreeNode(6);
        TreeNode node3 = new TreeNode(20, node6, node7);
        TreeNode node2 = new TreeNode(9, node4, node5);
        TreeNode node1 = new TreeNode(3, node2, node3);

        int i = find_the_value_in_the_lower_left_corner_of_the_tree(node1);
        System.out.println(i);
    }
}
