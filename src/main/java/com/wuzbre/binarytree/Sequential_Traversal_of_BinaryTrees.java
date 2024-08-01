package com.wuzbre.binarytree;

import java.util.*;

public class Sequential_Traversal_of_BinaryTrees {


    public static List<List<Integer>> sequential_Traversal_of_BinaryTrees_For_BFS_iter(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return null;
        int deep = 0;
        TreeNode cur = root;

        return null;
    }

    // 层序遍历自顶向下
    public static List<List<Integer>> sequential_Traversal_of_BinaryTrees_For_BFS_queue(TreeNode root) {
        if (root == null) return null;
        ArrayList<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int size = que.size();

            while (size > 0) {
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


    // 层序遍历自底向顶
    public static List<List<Integer>> sequential_Traversal_of_BinaryTrees_For_BFS_queue2(TreeNode root) {
        if (root == null) return null;
        ArrayList<List<Integer>> resList = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        while (!que.isEmpty()) {
            int queSize = que.size();
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < queSize; i++) {
                TreeNode tmp = que.pollFirst();
                if (tmp.left != null) que.offerLast(tmp.left);
                if (tmp.right != null) que.offerLast(tmp.right);
                tmpList.add(tmp.val);
            }
            resList.add(tmpList);
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = resList.size() - 1; i >= 0; i--) {
            result.add(resList.get(i));
        }

        return result;
    }


    public static List<List<Integer>> sequential_Traversal_of_BinaryTrees_For_BFS_queue2_for_best_way(TreeNode root) {
        if (root == null) return null;

        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            ans.addFirst(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode b = new TreeNode(9);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(20, d, e);
        TreeNode a = new TreeNode(3, b, c);


        List<List<Integer>> lists = sequential_Traversal_of_BinaryTrees_For_BFS_queue2_for_best_way(a);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
