package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 */
public class Test29 {
    public static void main(String[] args) {
        Test29 t = new Test29();
        int i = 0;
//        i = t.divide(-2147483648,2);
//        System.out.println(i);
//        System.out.println(-2147483648/2);
//        i = t.divide(-2147483647,-2);
//        System.out.println(i);
//        System.out.println(-2147483647/-2);
//
//        i = t.divide(2147483647,-2147483648);
//        System.out.println(i);
//        System.out.println(2147483647/-2147483648);
//
//        i = t.divide(-2147483648,2147483647);
//        System.out.println(i);
//        System.out.println(-2147483648/2147483647);
//
//        i = t.divide(-2147483648,122481295);
//        System.out.println(i);
//        System.out.println(-2147483648/122481295);
//
//        i = t.divide(-2147483648,-1);
//        System.out.println(i);
//        System.out.println(-2147483648/-1);

        i = t.divide(-2147483648,-1109186033);
        System.out.println(i);
        System.out.println(-2147483648/-1109186033);
    }

    /**
     * 我的实现
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(divisor==1){
            return dividend;
        }else if(divisor==-1){
            if(dividend==Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            return -1*dividend;
        }else if(dividend == Integer.MAX_VALUE&&divisor==Integer.MIN_VALUE){
            return 0;
        }else if(dividend == Integer.MIN_VALUE&&divisor == Integer.MAX_VALUE){
            return -1;
        }

        boolean fushu = true;
        if(dividend<0&&divisor<0){
            fushu = false;
        }else if(dividend>0&&divisor>0){
            fushu = false;
        }else if(dividend==0){
            return 0;
        }

        int dividend1 = Math.abs(dividend);
        if(dividend1==Integer.MIN_VALUE){
            dividend1 = Integer.MAX_VALUE;
        }
        int divisor1 = Math.abs(divisor);
        if(divisor1==Integer.MIN_VALUE){
            divisor1 = Integer.MAX_VALUE;
        }
        if(dividend1<divisor1){
            return 0;
        }

        String bcs = Integer.toBinaryString(dividend1);
        String cs = Integer.toBinaryString(divisor1);
        if(dividend==Integer.MIN_VALUE){
            bcs  = jiafa(bcs,"1");
        }
        if(divisor==Integer.MIN_VALUE){
            cs  = jiafa(cs,"1");
        }
        int start = 0;

        StringBuffer sb = new StringBuffer();
        String sub = "";

        while(start<bcs.length()){
            sub += bcs.charAt(start);
            if(bdx(sub.toString(),cs)){
                sb.append("1");
                sub = jianfa(sub,cs);
            }else{
                sb.append("0");
            }
            start ++;
        }
        int res = Integer.valueOf(sb.toString(),2);
        return fushu?-1*res:res;
    }


    private boolean bdx(String b1,String b2){
        if(b1.length()<b2.length()){
            return false;
        }else if(b1.length()>b2.length()){
            return true;
        }else {
            char[] c1 = b1.toCharArray();
            char[] c2 = b2.toCharArray();
            for(int i = 0 ; i < c1.length ; i ++){
                if(c1[i]>c2[i]){
                    return true;
                }
                if(c1[i] < c2[i]){
                    return false;
                }
            }
        }
        return true;
    }
    private String jiafa(String b1,String b2){
        int b11 = Integer.valueOf(b1,2);
        int b22 = Integer.valueOf(b2,2);
        int b33 = b11+b22;
        return Integer.toBinaryString(b33);
    }
    private String jianfa(String b1,String b2){
        char[] c1 = b1.toCharArray();
        char[] c2 = b2.toCharArray();
        StringBuffer sb = new StringBuffer();
        char[] c3 = new char[c1.length];
        int jiewei = 0;
        for(int i = c1.length-1 ,j=c2.length; i >=0 ; i--,j--){
            if(j>=0) {
                if (c1[i] == c2[j]) {
                    if(jiewei>0){
                        c3[i] = '1';
                        jiewei ++;
                    }else{
                        c3[i] = '0';
                    }
                } else if (c1[i] == '1' && c2[j] == '0') {
                    if (jiewei > 0) {
                        c3[i] = '0';
                        jiewei--;
                    } else {
                        c3[i] = '1';
                    }

                } else if (c1[i] == '0' && c2[j] == '1') {
                    c3[i] = '0';
                    jiewei++;
                }
            }else{
                if(c1[i]=='1'){
                    if(jiewei>0){
                        c3[i] = '0';
                        jiewei --;
                    }else{
                        c3[i] = '1';
                    }
                }else{
                    if(jiewei>0){
                        c3[i] = '1';
                        jiewei ++;
                    }else{
                        c3[i] = '0';
                    }
                }
            }
        }
        return c3.toString();
    }
}
