package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class Test125 {

    public static void main(String[] args) {
        Test125 t = new Test125();
        boolean re = t.isPalindrome2("");
        System.out.println(re);
    }

    /**
     * 我的实现1
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toUpperCase().trim();
        char[] chars = s.toCharArray();
        char[] cs = new char[chars.length];
        int i = 0;
        for (char c : chars) {
            if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90)) {
                cs[i++] = c;
            }
        }
        if (i == 0) {
            return true;
        }
        i--;
        for (int j = 0, k = i; j <= i / 2; j++, k--) {
            if (cs[j] != cs[k]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 我的实现2
     *
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            boolean isI = false;
            boolean isJ = false;
            if(chars[i] >= 97 && chars[i] <= 122){
                chars[i] -= 32;
            }
            if(chars[j] >= 97 && chars[j] <= 122){
                chars[j] -= 32;
            }
            if ((chars[i] >= 48 && chars[i] <= 57) || (chars[i] >= 65 && chars[i] <= 90)) {
                isI = true;
            }
            if ((chars[j] >= 48 && chars[j] <= 57) || (chars[j] >= 65 && chars[j] <= 90)) {
                isJ = true;
            }
            if(isI&&isJ&&chars[i]!=chars[j]){
                return false;
            }else if(isI&&isJ&&chars[i]==chars[j]) {
                i++;j--;
            }else if(!isI&&!isJ) {
                i++;j--;
            }else{
                if(isI)j--;
                if(isJ)i++;
            }
        }
        return true;
    }
}
