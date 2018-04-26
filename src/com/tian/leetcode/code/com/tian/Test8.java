package com.tian.leetcode.code.com.tian;

public class Test8 {

    public static void main(String[] args) {
        Test8 t = new Test8();
        int a = t.myAtoi("-000000000000001");
        System.out.println(a);
        a = t.myAtoi("  0000000000012345678");
        System.out.println(a);
        a = t.myAtoi("   +0 123");
        System.out.println(a);
        a = t.myAtoi("+1");
        System.out.println(a);
        a = t.myAtoi("-");
        System.out.println(a);
        a = t.myAtoi("-9147483678");
        System.out.println(a);
        a = t.myAtoi("");
        System.out.println(a);
        a = t.myAtoi("  ");
        System.out.println(a);
    }

    /**
     * 我的实现 已经很快了
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        if("".equals(str))return 0;
        char[] cs = str.toCharArray();
        boolean isFirst = true,isFushu = false;
        int res = 0;
        for(char c : cs){
            if(c==32&&isFirst){
                continue;
            }else if(c>=48&&c<=57){
                isFirst = false;
                if(res<=(Integer.MAX_VALUE/10+Integer.MAX_VALUE%10)){
                    res = res*10+c-48;
                }else{
                    return isFushu?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
            }else if((c==45||c==43)&&isFirst){
                isFirst = false;
                if(c==45){
                    isFushu = true;
                }
            }else{
                break;
            }
        }
        if(res<0){
            return isFushu?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }else{
            return isFushu?-1*res:res;
        }
    }
}
