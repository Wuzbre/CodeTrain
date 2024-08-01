package com.wuzbre.binarytree;

import javax.management.Query;
import java.util.Deque;
import java.util.LinkedList;

public class The_Number_Of_Nodes_Of_a_Complete_BinaryTree {

    public static Integer the_Number_Of_Nodes_Of_a_Complete_BinaryTree(TreeNode root){
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int sum = 0;

        while (!que.isEmpty()){
            int size = que.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                sum ++;
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return sum;

    }


    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2,node4,node5);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);

        TreeNode node = new TreeNode(1);
        TreeNode node6 = null;

        Integer integer = the_Number_Of_Nodes_Of_a_Complete_BinaryTree(node6);
        System.out.println(integer);


    }
}
