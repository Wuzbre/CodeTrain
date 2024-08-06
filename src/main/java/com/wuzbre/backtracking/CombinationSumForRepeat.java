package com.wuzbre.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumForRepeat {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> c(int[] candidates, int target) {
        result.clear();
        path.clear();
        b(candidates, target, 0, 0);
        return result;
    }

    public void b(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.offer(candidates[i]);
            b(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    // 以下方法是剪枝过后的发方法，确实优秀
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }

    public static void main(String[] args) {
        CombinationSumForRepeat a = new CombinationSumForRepeat();
        List<List<Integer>> combine = a.c(new int[]{2, 5, 3}, 7);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

}
