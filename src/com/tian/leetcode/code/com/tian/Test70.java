package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class Test70 {

    public static void main(String[] args) {
        Test70 t = new Test70();
        int tt = t.climbStairs(4);
        System.out.println(tt);
    }

    /**
     * 我的实现  没实现出来
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n==2){
            return 2;
        }
        int count = 0;
        int count_1 = 2;
        int count_2 = 1;
        for (int i = 3; i <= n; i++) {
            count = count_1 +count_2;
            count_2 = count_1;
            count_1 = count;
        }
        return count;
    }
}
