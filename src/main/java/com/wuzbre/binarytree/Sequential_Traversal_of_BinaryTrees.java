package com.wuzbre.binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sequential_Traversal_of_BinaryTrees {


    public static List<List<Integer>> sequential_Traversal_of_BinaryTrees_For_BFS_iter(TreeNode root){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root== null) return null;
        int deep = 0;
        TreeNode cur = root;

        return null;
    }


    public static List<List<Integer>> sequential_Traversal_of_BinaryTrees_For_BFS_queue(TreeNode root){
        if (root == null) return null;
        ArrayList<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int size = que.size();

            while (size > 0){
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);

                size--;
            }
            resList.add(itemList);
        }
        return resList;
    }


    public static void main(String[] args) {
        TreeNode b = new TreeNode(9);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(20,d,e);
        TreeNode a = new TreeNode(3,b,c);


        List<List<Integer>> lists = sequential_Traversal_of_BinaryTrees_For_BFS_queue(a);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
