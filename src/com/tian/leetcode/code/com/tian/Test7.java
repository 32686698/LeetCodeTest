package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Test7 {

    public static  void main(String[] args){
        Test7 t = new Test7();
        int t = t.reverse(123);
        System.out.println(t);
    }

    /**
     * 自己的实现1
     * @param x
     * @return
     */
    public int reverse(int x) {
        String strX = new String(x);
        char[] chars = strX.toCharArray();
        String newStr = "";
        for(int i = chars.length -1 ;i >= 0 ;i ++){
            newStr+=chars[i]+"";
            if(i==0&&chars[0]=='-'){
                newStr = "-"+newStr;
            }
        }
        return  new Integer(newStr);
    }

}
