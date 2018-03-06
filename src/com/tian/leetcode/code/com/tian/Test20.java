package com.tian.leetcode.code.com.tian;

import java.util.Stack;

/**
 *https://leetcode.com/problems/valid-parentheses/description/
 */
public class Test20 {

    public static  void main(String[] args){
        Test20 t = new Test20();
        boolean tt = t.isValid2("){");
        System.out.println(tt);
    }

    /**
     * 我自己的实现
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        int i = 0;
        int le = s.length();
        while (i++<le/2) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return  "".equals(s);
    }

    /**
     * 用堆栈实现
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        if(s.length()%2==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }else if(c=='}'){
                if(stack.isEmpty()||stack.pop()!='{'){
                    return false;
                }
            }else if(stack.isEmpty()||c==']'){
                if(stack.pop()!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
