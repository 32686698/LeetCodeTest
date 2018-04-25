package com.tian.leetcode.code.com.tian;

public class Test5 {

    public static void main(String[] args) {
        Test5 t = new Test5();
        String s = t.longestPalindrome("abcda");
        System.out.println(s);
    }


    public String longestPalindrome(String s) {
        String sub1 = "", sub2 = "", res = "", sub = "";
        for (int i = 1; i < s.length(); i++) {
            sub1 = s.substring(0, i);
            sub2 = s.substring(i, s.length());
            for (int n = i - 1, m = 0; n >= 0 && m < sub2.length(); n--, m++) {
                if (sub1.charAt(n) != sub2.charAt(m)) {
                    break;
                } else {
                    sub = s.substring(n, i + m + 1);
                    res = sub.length() > res.length() ? sub : res;
                }
            }
            sub2 = s.substring(i + 1, s.length());
            for (int n = i - 1, m = 0; n >= 0 && m < sub2.length(); n--, m++) {
                if (sub1.charAt(n) != sub2.charAt(m)) {
                    break;
                } else {
                    sub = s.substring(n, i + m + 2);
                    res = sub.length() > res.length() ? sub : res;
                }
            }
        }
        if (res.equals("")) {
            return s.charAt(0) + "";
        }
        return res;
    }


    /**
     * 牛逼的实现 还不太明白
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] range = new int[]{0, 1};
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            i = helper(c, i, range);
        }
        return s.substring(range[0], range[1]);
    }

    public int helper(char[] c, int index, int[] range) {
        int low = index, hi = index;
        while (hi < c.length - 1 && c[hi] == c[hi + 1]) hi++;
        int reset = hi;
        while (low - 1 >= 0 && hi + 1 < c.length && c[hi + 1] == c[low - 1]) {
            hi++;
            low--;
        }
        if (hi - low + 1 > range[1] - range[0]) {
            range[0] = low;
            range[1] = hi + 1;
        }
        return reset;
    }
}
