package com.wuzbre.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Preorder_Mid_Postorder_Traversal {
    // 前序遍历·递归·LC144_二叉树的前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    public static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
    // 中序遍历·递归·LC94_二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);             // 注意这一句
        inorder(root.right, list);
    }
// 后序遍历·递归·LC145_二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);             // 注意这一句
    }


    public static void main(String[] args) {
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode b = new TreeNode(2,d,e);
        TreeNode f = new TreeNode(6);
        TreeNode c = new TreeNode(3,f,null);
        TreeNode a = new TreeNode(1,b,c);

        List<Integer> integers = preorderTraversal(a);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }


}
