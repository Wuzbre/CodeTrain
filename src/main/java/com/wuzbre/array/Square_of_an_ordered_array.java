package com.wuzbre.array;

public class Square_of_an_ordered_array {
    public static int[] square_of_an_ordered_array(int[] nums) {
        int left = 0, right = nums.length - 1;
        int resultIndex = nums.length - 1;
        int[] result = new int[nums.length];
        while (left < right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[resultIndex] = nums[left] * nums[left];
                resultIndex--;
                left++;
            } else {
                result[resultIndex] = nums[right] * nums[right];
                resultIndex--;
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = {-4, -1, 0, 1, 3, 10};
        int[] res = square_of_an_ordered_array(ints);
        for (int re : res) {
            System.out.println(re);
        }

    }
}
