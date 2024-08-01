package com.wuzbre.binarytree;

public class PerfectTreeNode {
    public int val;
    public PerfectTreeNode left;
    public PerfectTreeNode right;
    public PerfectTreeNode next;

    public PerfectTreeNode() {
    }

    public PerfectTreeNode(int val) {
        this.val = val;
    }

    public PerfectTreeNode(int val, PerfectTreeNode left, PerfectTreeNode right, PerfectTreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }


}
