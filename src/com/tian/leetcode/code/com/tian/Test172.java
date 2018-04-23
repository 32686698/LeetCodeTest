package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
 */
public class Test172 {

    public static void main(String[] args) {
        Test172 t = new Test172();
        int a = t.trailingZeroes2(1808548329);
        System.out.println(a);
    }

    /**
     * 我的实现 ，没有解题
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 1,re = 0;
        for(int i = 1;i<=n;i++){
            count = count * i;
            while (count%10==0){
                re ++;
                count = count/1000000;//这里有问题
            }
        }
        return re;
    }


    /**
     * 牛逼的实现，还没太理解
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        if (n / 5 < 5) {
            return n / 5;
        } else {
            return n /5 + trailingZeroes2(n / 5);
        }
    }
}
