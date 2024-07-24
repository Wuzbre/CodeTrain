package com.wuzbre.array;

public class BinarySearch {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */

    public static int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(binarySearch(nums, 9));
    }
}
