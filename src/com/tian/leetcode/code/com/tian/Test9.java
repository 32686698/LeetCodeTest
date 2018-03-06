package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class Test9 {
    public static  void main(String[] args){
        Test9 t = new Test9();
        boolean tt = t.isPalindrome(1);
        System.out.println(tt);
    }

    /**
     * 我自己的实现
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int newX = 0;
        for (int xx = x;xx!=0;xx/=10){
            newX = newX*10+xx%10;
        }
        return newX==x;
    }
}
