package com.wuzbre.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class The_Minimum_Absolute_Difference_of_BinarySearchTrees {
    TreeNode pre;
    int result = Integer.MAX_VALUE;

    // 递归
    public int getMinDiff(TreeNode root){
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root){
        if (root == null) return;
        traversal(root.left);
        if (pre != null){
            result = Math.min(result,root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }




    //统一的迭代方法----》用栈
    public int getMinimumDifference(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        int result = Integer.MAX_VALUE;
        if (root != null){
            stack.add(root);
        }

        while (!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if (curr != null){
                stack.pop();
                if (curr.right != null){
                    stack.add(curr.right);
                }
                stack.add(curr);
                stack.add(null);
                if (curr.left != null){
                    stack.add(curr.left);
                }
            }else {
                stack.pop();
                TreeNode temp = stack.pop();
                if (pre != null) result = Math.min(result,Math.abs(temp.val - pre.val));
                pre = temp;
            }
        }
        return result;
    }


    // 不统一的前序迭代遍历
    public List<Integer> front(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return result;
    }

    //中序遍历
    public List<Integer> mid(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.add(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    //后续遍历
    public List<Integer> behind(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }


    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node3 = new TreeNode(10,null,node6);
        TreeNode node2 = new TreeNode(4,node4,node5);
        TreeNode node1 = new TreeNode(8,node2,node3);
        The_Minimum_Absolute_Difference_of_BinarySearchTrees a = new The_Minimum_Absolute_Difference_of_BinarySearchTrees();
        int minimumDifference = a.getMinimumDifference(node1);
//        System.out.println(minimumDifference);

        List<Integer> lists1 = a.front(node1);
        List<Integer> lists2 = a.mid(node1);
        List<Integer> lists3 = a.behind(node1);
        for (Integer list : lists1) {
            System.out.print(list);
        }
        System.out.println();
        for (Integer list : lists2) {
            System.out.print(list);
        }
        System.out.println();
        for (Integer list : lists3) {
            System.out.print(list);
        }
    }


}
