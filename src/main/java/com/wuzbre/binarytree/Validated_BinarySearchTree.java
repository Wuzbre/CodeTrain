package com.wuzbre.binarytree;

public class Validated_BinarySearchTree {
    private long prev = Long.MIN_VALUE;
    public boolean validated_BinarySearchTree(TreeNode root){
        if (root == null) return true;
        if (!validated_BinarySearchTree(root.left)) return false;
        if (root.val <= prev) return false;
        prev = root.val;
        return validated_BinarySearchTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1,node3,null);
        TreeNode node1 = new TreeNode(2,node2,node3);
        Validated_BinarySearchTree validatedBinarySearchTree = new Validated_BinarySearchTree();
        boolean b = validatedBinarySearchTree.validated_BinarySearchTree(node1);
        System.out.println(b);
    }
}
