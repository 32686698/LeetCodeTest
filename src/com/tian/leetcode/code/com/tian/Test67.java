package com.tian.leetcode.code.com.tian;

import com.tian.shujujiegou.code1.Util;

/**
 * https://leetcode.com/problems/add-binary/description/
 */
public class Test67 {

    public static  void main(String[] args){
        Test67 t = new Test67();
        String tt = t.addBinary("111",
                "1110");
        System.out.println(tt);
    }

    /**
     * 我的实现 比较快了
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if(a.length()<b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int maxL = a.length();
        char[] chars1 = a.toCharArray();
        char[] chars2 = new char[maxL];
        char[] chars3 = new char[maxL];
        char[] temp = b.toCharArray();
        for (int i = maxL - 1,j = temp.length-1; i >= 0; i--,j--) {
            if(j>=0){
                chars2[i] = temp[j];
            }else{
                chars2[i] = '0';
            }

        }
        //进位
        char c = '0';
        for (int i = maxL -1 ; i >= 0; i--) {
            int count = chars1[i]+chars2[i]+c;
            if(count==147){
                chars3[i] = '1';
                c = '1';
            }else if(count==146){
                chars3[i] = '0';
                c = '1';
            }else if(count==145){
                chars3[i] = '1';
                c = '0';
            }else if(count==144){
                chars3[i] = '0';
                c = '0';
            }
        }
        if(c=='0'){
            return new String(chars3);
        }else{
            return c+new String(chars3);
        }
    }
}
