package com.wuzbre.binarytree;

import java.util.List;

public class Search_in_BinarySearchTrees {

    public static TreeNode search_in_BinarySearchTrees(TreeNode root,int target){
        while (root != null){
            if (root.val > target) root = root.left;
            else if (root.val < target) root = root.right;
            else return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2,node4,node3);
        TreeNode node1 = new TreeNode(4,node2,node5);
        TreeNode node = search_in_BinarySearchTrees(node1,2);
        List<List<Integer>> lists = Sequential_Traversal_of_BinaryTrees.sequential_Traversal_of_BinaryTrees_For_BFS_queue(node);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
