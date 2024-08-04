package com.wuzbre.binarytree;

import java.util.ArrayList;
import java.util.List;

public class All_paths_to_a_BinaryTree {

    public static List<String> all_paths_to_a_BinaryTree(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        traversal(root,path,res);
        return res;
    }


    public static void traversal(TreeNode root,List<Integer> paths,List<String> res){
        paths.add(root.val);
        if (root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }

        // 递归开始
        if (root.left != null){
            traversal(root.left,paths,res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null){
            traversal(root.right,paths,res);
            paths.remove(paths.size() - 1);
        }
    }


    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4,node8,node9);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node4 = new TreeNode(0);
        TreeNode node3 = new TreeNode(8,node6,node7);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(6,node2,node3);
        List<String> strings = all_paths_to_a_BinaryTree(node1);
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
