package com.tian.leetcode.code.com.tian;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/151243751/
 */
public class Test168 {

    /**
     * 我的实现
     * @param args
     */
    public static void main(String[] args){
        Test168 t = new Test168();
        String s = t.convertToTitle(53

        );
        System.out.println(s);
    }

    /**
     * 简单的实现
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        List<Integer> list = new ArrayList<>();
        while (n>26){
            int yu = n%26;
            if(yu==0){
                yu = 26;
                n--;
            }
            list.add(yu);
            n = n/26;
        }
        list.add(n);
        StringBuffer sb = new StringBuffer();
        for(int i = list.size()-1;i>=0 ; i--){
            char a = (char)(list.get(i)+64);
            sb.append(a);
        }
        return sb.toString();
    }

    public String convertToTitle2(int n) {

        StringBuilder res = new StringBuilder();
        while(n>0){
            res.append((n%26) != 0 ? (char)('A'- 1 + (n%26)) : (char)('Z'));
            n= (n-1)/26;
        }

        return res.reverse().toString();
    }
}
