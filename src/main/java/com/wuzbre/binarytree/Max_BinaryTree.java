package com.wuzbre.binarytree;

public class Max_BinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
         return constructMaximumBinaryTree1(nums,0, nums.length);
    }

    public static TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) return null;
        if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);

        int maxIndex = leftIndex;
        int maxValue = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxValue){
              maxValue = nums[i];
              maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(maxValue);

        node.left = constructMaximumBinaryTree1(nums,leftIndex,maxIndex);
        node.right = constructMaximumBinaryTree1(nums,maxIndex+1,rightIndex);
        return node;
    }


    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 6, 0, 5};
        TreeNode node = constructMaximumBinaryTree(ints);
    }
}
