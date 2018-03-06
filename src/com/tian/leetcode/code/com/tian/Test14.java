package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Test14 {
    public static  void main(String[] args){
        Test14 t = new Test14();
        String tt = t.longestCommonPrefix2(new String[]{"12345","1234","123"});
        System.out.println(tt);
    }

    /**
     * 我的实现
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) {
            return "";
        }
        char[] chars = strs[0].toCharArray();
        String re = "";
        for(int i = 1;i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            for (int j = 0 ; j < (chars.length>temp.length?temp.length:chars.length) ; j ++){
                if(chars[j]!=temp[j]){
                    break;
                }
                re += chars[j];
            }
            chars = re.toCharArray();
            re = "";
        }
        return new String(chars);
    }


    /**
     * 牛逼的实现
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            while(str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
