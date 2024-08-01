package com.wuzbre.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class Symmetric_Binary_Tree {


    public static boolean symmetric_Binary_Tree_For_Iter(TreeNode left,TreeNode right){
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean b = symmetric_Binary_Tree_For_Iter(left.left, right.right);
        boolean b1 = symmetric_Binary_Tree_For_Iter(left.right, right.left);
        return b && b1;
    }

    public static boolean compare(TreeNode root){
        boolean b = symmetric_Binary_Tree_For_Iter(root.left, root.right);
        return b;
    }


    public static boolean symmetric_Binary_Tree_For_Queue(TreeNode root){
        if (root == null) return false;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerFirst(root.left);
        que.offerLast(root.right);
        while (!que.isEmpty()){
            TreeNode left = que.pollFirst();
            TreeNode right = que.pollLast();
            if (left == null && right == null) continue;
            if (left != null && right == null) return false;
            if (left == null && right != null) return false;
            if (left.val != right.val) return false;

            que.offerFirst(left.left);
            que.offerFirst(left.right);
            que.offerLast(right.right);
            que.offerLast(right.left);
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2,null,node5);
        TreeNode node2 = new TreeNode(2,node4,null);
        TreeNode node1 = new TreeNode(1,node2,node3);
        boolean compare = symmetric_Binary_Tree_For_Queue(node1);
        System.out.println(compare);
    }


}
