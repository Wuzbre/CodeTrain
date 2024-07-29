package com.wuzbre.binarytree;

import java.util.*;

public class Iterative_Traversal_of_BinaryTrees {
    // 前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        //栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // 中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                cur = cur.right;
            }
        }
        return result;
    }

    //后序遍历很简单，按照前序遍历来，然后把数组反转一下就行了
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }


}
