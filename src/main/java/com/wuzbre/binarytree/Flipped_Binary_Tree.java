package com.wuzbre.binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class Flipped_Binary_Tree {

    public static TreeNode flipped_Binary_Tree_For_Front_iter(TreeNode root){
        if (root == null) return null;
        swap(root);
        flipped_Binary_Tree_For_Front_iter(root.left);
        flipped_Binary_Tree_For_Front_iter(root.right);
        return root;
    }


    public static void swap(TreeNode root){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }


    //BFS遍历层序遍历
    public static TreeNode flipped_Binary_Tree_For_BFS(TreeNode root){
        if (root == null) return null;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                swap(node);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode b = new TreeNode(9);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(20, d, e);
        TreeNode a = new TreeNode(3, b, c);

        TreeNode node = flipped_Binary_Tree_For_BFS(a);

    }
}
