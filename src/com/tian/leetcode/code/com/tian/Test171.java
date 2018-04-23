package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class Test171 {

    public static void main(String[] args) {
        Test171 t  = new Test171();
        int a = t.titleToNumber("Z");
        System.out.println(a);
    }

    /**
     * 我的实现
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int count = 0;
        int jisu = 1;
        for(int i = cs.length-1;i>=0;i--){
            count += (cs[i] - 64)*jisu;
            jisu *= 26;
        }
        return count;
    }
}
