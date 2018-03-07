package com.tian.leetcode.code.com.tian;

import com.tian.shujujiegou.code1.Util;

/**
 * https://leetcode.com/problems/plus-one/description/
 */
public class Test66 {

    public static  void main(String[] args){
        Test66 t = new Test66();
        int[] tt = t.plusOne(new int[]{9,7,9,9});
        Util.printlnArray(tt);
    }

    /**
     * 我的实现
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1 ; i >= 0; i--) {
            if(digits[i]!=9){
                digits[i] += 1;
                break;
            }
            digits[i] = 0;
        }
        if(digits[0] == 0){
            int [] re = new int[digits.length+1];
            re[0] = 1;
            return re;
        }
        return digits;
    }

}
