package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class Test121 {

    public  static void main(String[] args){
        Test121 t = new Test121();
        int re = t.maxProfit(new int[]{1,2});
        System.out.println(re);
    }

    /**
     * 我的实现
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0||prices.length==1){

            return 0;
        }
        int max = 0;
        int minNum = prices[0];
        for(int i : prices){
            max = Math.max(max,i-minNum);
            minNum = Math.min(minNum,i);
        }
        return max;
    }
}
