package com.wuzbre.array;

import java.util.Scanner;

public class Developers_Purchase_Land {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int y = sc.nextInt();
        int[][] nums = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

    }
}
