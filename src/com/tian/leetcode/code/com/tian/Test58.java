package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 */
public class Test58 {

    public static  void main(String[] args){
        Test58 t = new Test58();
        int tt = t.lengthOfLastWord("Hello World");
        System.out.println(tt);
    }

    /**
     * 我自己的实现 ，这题够无聊的
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSp = s.lastIndexOf(" ");
        if (lastSp==-1){
            return s.length();
        }
        return s.length() - lastSp -1 ;
    }
}
