package com.wuzbre.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Combination combination = new Combination();
        System.out.println(System.currentTimeMillis());
        List<List<Integer>> combine = combination.combine(100, 4);
        System.out.println(System.currentTimeMillis());
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
//                System.out.print(integer);
            }
//            System.out.println();
        }

    }
}
