package com.wuzbre.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_the_maximum_value_in_each_tree_row {

    public static List<Integer> find_the_maximum_value_in_each_tree_row(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                sum = Math.max(sum, node.val);
            }
            result.add(sum);

        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(9);
        TreeNode b = new TreeNode(3, d, e);
        TreeNode c = new TreeNode(2, null, f);
        TreeNode a = new TreeNode(1, b, c);


        List<Integer> theMaximumValueInEachTreeRow = find_the_maximum_value_in_each_tree_row(a);
        for (Integer integer : theMaximumValueInEachTreeRow) {
            System.out.println(integer);
        }

    }
}
