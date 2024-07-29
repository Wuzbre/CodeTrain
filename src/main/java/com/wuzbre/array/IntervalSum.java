package com.wuzbre.array;

import java.util.Scanner;

public class IntervalSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }

        while (sc.hasNext()){
            int sum = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int i = a; i < b+1; i++) {
                sum += nums[i];
            }
            System.out.println(sum);
        }

    }
}
