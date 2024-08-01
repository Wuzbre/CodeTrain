package com.wuzbre.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Fill_each_nodes_next_right_node_pointer {

    public static PerfectTreeNode fill_each_nodes_next_right_node_pointer(PerfectTreeNode root){

        Deque<PerfectTreeNode> que = new LinkedList<PerfectTreeNode>();
        if (root != null) que.add(root);

        while (!que.isEmpty()){
            int size = que.size();
            PerfectTreeNode tmpNext = null;
            for (int i = 0; i < size; i++) {
                PerfectTreeNode node = que.poll();
                if (i == size-1){
                    node.next = tmpNext;
                }else {
                    node.next = que.getFirst();
                }
                if (node.left != null) que.offerLast(node.left);
                if (node.right != null) que.offerLast(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        PerfectTreeNode a4 = new PerfectTreeNode(4);
        PerfectTreeNode a5 = new PerfectTreeNode(5);
        PerfectTreeNode a6 = new PerfectTreeNode(6);
        PerfectTreeNode a7 = new PerfectTreeNode(7);
        PerfectTreeNode a3 = new PerfectTreeNode(2,a4,a5,null);
        PerfectTreeNode a2 = new PerfectTreeNode(3,a6,a7,null);
        PerfectTreeNode a1 = new PerfectTreeNode(1,a3,a2,null);

        PerfectTreeNode perfectTreeNode = fill_each_nodes_next_right_node_pointer(a1);

    }
}
