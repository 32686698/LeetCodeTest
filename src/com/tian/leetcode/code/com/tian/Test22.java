package com.tian.leetcode.code.com.tian;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 */
public class Test22 {
    public static void main(String[] args) {
        Test22 t = new Test22();
        List list = t.generateParenthesis(1);
        System.out.println(list);
    }

    /**
     * 我的实现 超级慢
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> current = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            if (i == 0) {
                current.add("(");
                continue;
            }
            List<String> temp = new ArrayList<>();
            for (String str : current) {
                temp.add(str + ")");
                temp.add(str + "(");
            }
            current = temp;
        }
        Iterator<String> it = current.iterator();
        while (it.hasNext()) {
            int qk = 0, hk = 0;
            String str = it.next();
            boolean isdel = false;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    qk++;
                } else if (str.charAt(i) == ')') {
                    hk++;
                    if (qk < hk) {
                        it.remove();
                        isdel = true;
                        break;
                    }
                }
            }
            if (qk != hk && !isdel) {
                it.remove();
            }
        }
        return current;
    }

    /**
     * 牛逼的实现
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}
