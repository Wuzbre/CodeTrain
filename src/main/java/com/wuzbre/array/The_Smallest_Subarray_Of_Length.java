package com.wuzbre.array;

public class The_Smallest_Subarray_Of_Length {

    public static int the_Smallest_Subarray_Of_Length(int[] nums, int s) {
        int sum = 0; //计算用来比较s的总和
        int left = 0;//左边界
        int result = 0;//每一个窗口长度
        int end = Integer.MAX_VALUE;//用来比较的最大值，去除0的影响
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                result = i - left + 1;
                end = Math.min(end, result);
                sum -= nums[left];
                left++;
            }
        }
        return end == Integer.MAX_VALUE ? 0 : end;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(the_Smallest_Subarray_Of_Length(nums, 7));

    }
}
