package com.wuzbre.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int k, int sum) {
        build(sum, k, 0, 1);
        return result;
    }

    public void build(int targetSum, int k, int sum, int startIndex) {
        if (sum == targetSum && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > targetSum) return;
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.offer(i);
            sum += i;
            build(targetSum, k, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }


    public static void main(String[] args) {
        CombinationSum combination = new CombinationSum();
        List<List<Integer>> combine = combination.combine(3, 7);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
}
