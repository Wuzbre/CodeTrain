package com.kama;

import java.util.ArrayList;
import java.util.Scanner;

public class test1 {

    public static int getPower1(String text){
        int maxNum = 0;
        int sum = 0;
        int tmpSum = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        String[] split = text.split(",");
        for (String s : split) {
            String[] tmp = s.split(":");
            maxNum = Math.max(maxNum,Integer.parseInt(tmp[0]));
            tmpSum += Integer.parseInt(tmp[0]);
            list1.add(Integer.parseInt(tmp[0]));
            list2.add(Integer.parseInt(tmp[1]));
        }
        for (int i = 0; i < list1.size(); i++) {
            if (maxNum == list1.get(i)){
                sum = tmpSum-maxNum+list2.get(i);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.next();
            System.out.println(getPower1(a));
        }
    }
}
