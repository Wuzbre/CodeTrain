package com.wuzbre.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Sum_of_left_leaves {

    public static int sum_of_left_leaves(TreeNode root) {
        if (root == null) return 0;
        int leftValue = sum_of_left_leaves(root.left);    // 左
        int rightValue = sum_of_left_leaves(root.right);  // 右

        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        int sum = midValue + leftValue + rightValue;  // 中
        return sum;
    }


    // 层序遍历
    public static int sum_of_left_leaves_for_iter(TreeNode root){
        int sum = 0;
        if (root == null) return 0;

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()){
            int size = que.size();
            while (size > 0){
                TreeNode node = que.poll();
                if (node.left != null){
                    que.offer(node.left);
                    if (node.left.left == null && node.left.right == null){
                        sum+= node.left.val;
                    }
                }
                if (node.right != null) que.offer(node.right);
                size--;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(6);
        TreeNode node3 = new TreeNode(20,node6,node7);
        TreeNode node2 = new TreeNode(9,node4,node5);
        TreeNode node1 = new TreeNode(3,node2,node3);

        int i = sum_of_left_leaves_for_iter(node1);
        System.out.println(i);
    }


}
