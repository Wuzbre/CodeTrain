package com.wuzbre.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Layer_Average_of_BinaryTree {


    public static List<Double> layer_Average_of_BinaryTree(TreeNode root){
        if (root == null) return null;
        ArrayList<Double> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()){
            int size = que.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                sum += node.val;
            }
            result.add(sum/size);

        }
        return result;
    }



    public static void main(String[] args) {
        TreeNode b = new TreeNode(9);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(20, d, e);
        TreeNode a = new TreeNode(3, b, c);

        List<Double> integers = layer_Average_of_BinaryTree(a);
        for (Double integer : integers) {
            System.out.println(integer);
        }

    }
}
