package com.wuzbre.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Right_View_Of_A_BinaryTree {
    public static List<Integer> right_View_Of_A_BinaryTree(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = que.poll();
                if (tmp.left != null) que.offer(tmp.left);
                if (tmp.right != null) que.offer(tmp.right);
                if (i == size - 1) result.add(tmp.val);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode d = new TreeNode(5);
        TreeNode b = new TreeNode(2, null, d);
        TreeNode e = new TreeNode(4);
        TreeNode c = new TreeNode(3, null, e);
        TreeNode a = new TreeNode(1, b, c);
        List<Integer> list = right_View_Of_A_BinaryTree(a);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
