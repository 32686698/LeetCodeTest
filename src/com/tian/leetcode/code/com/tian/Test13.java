package com.tian.leetcode.code.com.tian;


/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class Test13 {

    public static  void main(String[] args){
        Test13 t = new Test13();
        int tt = t.romanToInt("XLV");
        System.out.println(tt);
    }

    /**
     * 我的实现
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int result = 0;
        int fh = 1;
        char[] chars = s.toCharArray();
        for(int i = chars.length-1 ; i >= 0; i--){
            fh = 1;
            if(chars[i]=='I'){
                //判断符号
                if(i<chars.length-1&&chars[i+1]!='I'){
                    fh = 0;
                }
                if(fh==1){
                    result += 1;
                }else{
                    result -= 1;
                }
            }else if(chars[i]=='X'){
                //判断符号
                if(i<chars.length-1&&chars[i+1]!='I'&&chars[i+1]!='V'&&chars[i+1]!='X'){
                    fh = 0;
                }
                if(fh==1){
                    result += 10;
                }else{
                    result -= 10;
                }
            }else if(chars[i]=='C'){
                //判断符号
                if(i<chars.length-1&&chars[i+1]!='I'&&chars[i+1]!='V'&&chars[i+1]!='X'&&chars[i+1]!='C'&&chars[i+1]!='L'){
                    fh = 0;
                }
                if(fh==1){
                    result += 100;
                }else{
                    result -= 100;
                }
            }else if(chars[i]=='M'){
                result += 1000;
            }else if(chars[i]=='V'){
                result += 5;
            }else if(chars[i]=='L'){
                result += 50;
            }else if(chars[i]=='D'){
                result += 500;
            }
        }
        return result;
    }

    /**
     * 牛逼的实现
     * 思想是，当左则的结果大于I（1）、X（10）、C（100）时，只可能是减
     * @param s
     * @return
     */
    public int romanToInt1(String s) {
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    result += (result >= 5 ? -1 : 1);
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += (result >= 50 ? -10 : 10);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += (result >= 500 ? -100 : 100);
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}
