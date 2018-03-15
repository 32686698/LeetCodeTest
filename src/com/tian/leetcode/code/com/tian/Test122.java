package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Test122 {

    public  static void main(String[] args){
        Test122 t = new Test122();
        int re = t.maxProfit(new int[]{1});
        System.out.println(re);
    }

    /**
     * 我的实现
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int count = 0 ;
        int max = 0;
        int minNum = prices[0];
        for(int i : prices){
            max = Math.max(max,i-minNum);
            if(max != 0){
                count += max;
                max = 0;
                minNum = i;
            }else {
                minNum = Math.min(minNum, i);
            }

        }
        return count;
    }

    /**
     * 别人的实现,其实就是把最近的大于0的差的和求出来了
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }
        return total;
    }


}
