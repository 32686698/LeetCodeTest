package com.tian.leetcode.code.com.tian;

public class Test28 {

    public static  void main(String[] args){
        Test28 t = new Test28();
        int tt = t.strStr2("aabaa","baa");
        System.out.println(tt);
    }

    /**
     * 我的实现
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null||haystack.length()<needle.length()){
            return -1;
        }else{
            return haystack.indexOf(needle);
        }
    }

    /**
     * 我的实现2
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if(haystack==null||needle==null||haystack.length()<needle.length()){
            return -1;
        }else{
            int nl = needle.length();
            int i = 0;
            for (; i <= haystack.length()-nl ; i++) {
                if(haystack.substring(i,i+nl).equals(needle)){
                    return i;
                }
            }
            return -1;
        }
    }
}
