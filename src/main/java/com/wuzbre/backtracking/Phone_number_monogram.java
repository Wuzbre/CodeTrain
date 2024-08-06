package com.wuzbre.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Phone_number_monogram {

    LinkedList<String> result = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombiner(String digits) {
        if (digits == null || digits.length() == 0) return result;
        String[] numList = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(numList, digits, 0);
        return result;
    }
    public void backtracking(String[] numList, String digits, int num) {
        if (num == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String str = numList[Integer.parseInt(String.valueOf(digits.charAt(num)))];//-"0";
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(numList,digits,num+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        Phone_number_monogram phoneNumberMonogram = new Phone_number_monogram();
        List<String> strings = phoneNumberMonogram.letterCombiner("12");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
