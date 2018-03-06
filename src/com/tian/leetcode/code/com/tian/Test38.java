package com.tian.leetcode.code.com.tian;

import com.tian.shujujiegou.code1.Util;

/**
 * https://leetcode.com/problems/count-and-say/description/
 */
public class Test38 {

    public static  void main(String[] args){
        Test38 t = new Test38();
        String tt = t.countAndSay(4);
        System.out.println(tt);
    }

    /**
     * 我的实现
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String re = "11";

        for (int i = 2; i < n ; i++) {
            StringBuffer sb = new StringBuffer();
            char[] chars = re.toCharArray();
            int k = 1;
            for (int j = 0; j < chars.length; j++) {
                if(j+1 < chars.length && chars[j]==chars[j+1]){
                    k++;
                }else{
                    sb.append(k).append(chars[j]);
                    k = 1;
                }
            }
            re = sb.toString();
        }
        return re;
    }
}
