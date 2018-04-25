package com.tian.leetcode.code.com.tian;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 t = new Test3();
        int a = t.lengthOfLongestSubstring("abcddd");
        System.out.println(a);
    }

    /**
     * 我的实现
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        Set<Character> cs = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (cs.contains(chars[j])) {
                    res = Math.max(cs.size(), res);
                    cs = new HashSet<>();
                    break;
                }
                cs.add(chars[j]);
            }
            res = Math.max(cs.size(), res);
        }
        return res;
    }

    /**
     * 牛逼的实现 看不太懂
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] list = new int[256];
        int previous = -1, right = 0, max_len = 0;
        for (int i = 0; i < list.length; i++) {
            list[i] = -1;
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            if (list[(int) c] > previous) {
                previous = list[(int) c];
            }
            max_len = Math.max(max_len, right - previous);
            list[(int) c] = right++;
        }
        return max_len;
    }
}
