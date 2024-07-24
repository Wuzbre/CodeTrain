package com.wuzbre.array;

public class RemoveElement {
    /**
     * 移除元素使用快慢指针
     * @param nums
     * @param target
     * @return
     */

    public static int removeElement(int[] nums, int target) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != target){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));

    }
}
