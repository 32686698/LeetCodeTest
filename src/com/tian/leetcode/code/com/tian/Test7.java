package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Test7 {

    public static  void main(String[] args){
        Test7 t = new Test7();
        int tt = t.reverse2(123);
        System.out.println(tt);
    }

    /**
     * 自己的实现1
     * @param x
     * @return
     */
    public int reverse(int x) {
        String strX = x+"";
        char[] chars = strX.toCharArray();
        String newStr = "";
        for(int i = chars.length -1 ;i >= 0 ;i--){
            if(i==0&&chars[0]=='-'){
                newStr = "-"+newStr;
            }else
                newStr+=chars[i]+"";
        }
        try {
            return new Integer(newStr);
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 牛逼的实现
     * @param x
     * @return
     */
    public int reverse2(int x) {
        long result = 0;
        for(; x != 0; x /= 10){
            result = result * 10 + x % 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int)result;
    }

}
