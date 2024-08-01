package com.wuzbre.binarytree;

import java.util.*;

public class Sequential_Traversal_of_N_ForkTrees {


    public static List<List<Integer>> sequential_Traversal_of_N_ForkTrees(Node root){
        if (root == null) return null;
        ArrayList<List<Integer>> result = new ArrayList<>();

        Deque<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                tmpList.add(node.val);
                if (node.children != null){
                    for (Node child : node.children) {
                        que.offer(child);
                    }
                }
            }
            result.add(tmpList);
        }
        return result;
    }


    public static void main(String[] args) {
        Node node1 = new Node(6);
        Node node2 = new Node(5);
        Node node3 = new Node(4);
        Node node4 = new Node(3,Arrays.asList(node2,node1));
        Node node5 = new Node(2);
        Node node6 = new Node(1,Arrays.asList(node4,node5,node3));
        List<List<Integer>> lists = sequential_Traversal_of_N_ForkTrees(node6);
            for (List<Integer> list : lists) {
                for (Integer integer : list) {
                    System.out.println(integer);
                }
            }

    }
}
