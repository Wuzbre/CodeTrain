package com.wuzbre.binarytree;

import java.util.List;

public class Merged_BinaryTree {

    public static TreeNode merge(TreeNode t1,TreeNode t2){

        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val+=t2.val;
        t1.left = merge(t1.left,t2.left);
        t1.right = merge(t1.right,t2.right);
        return t1;
    }


    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3,null,node5);
        TreeNode node2 = new TreeNode(2,node4,null);
        TreeNode node1 = new TreeNode(1,node2,node3);

        TreeNode node51 = new TreeNode(5);
        TreeNode node41 = new TreeNode(4);
        TreeNode node31 = new TreeNode(3,null,node51);
        TreeNode node21 = new TreeNode(2,node41,null);
        TreeNode node11 = new TreeNode(1,node31,node21);


        TreeNode merge = merge(node1, node11);
        List<List<Integer>> lists =
                Sequential_Traversal_of_BinaryTrees.sequential_Traversal_of_BinaryTrees_For_BFS_queue(merge);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }

}
