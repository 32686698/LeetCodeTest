package com.tian;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 */
public class Test6 {

    public static void main(String[] args) {
        Test6 t = new Test6();
        t.convert("PAYPALISHIRING",4);
    }

    public String convert(String s, int numRows) {
        int zhouqigeshu = numRows*2-2;
        int zhouqileishu = numRows-1;
        char[] cs = s.toCharArray();
        char[][] css = new char[numRows][s.length()/zhouqigeshu * zhouqileishu];
        for(int i = 1 ; i <= cs.length;i ++){
            int zhouqi = i/zhouqileishu;
            int geshu = i%zhouqileishu;
            int zhouqilei = 1;
            if(geshu>numRows){
                zhouqilei += geshu - numRows;
            }
            int lei = zhouqileishu * (zhouqi-1) + zhouqilei;
            int hang = geshu;
            if(geshu>numRows){
                hang = numRows - (geshu - numRows);
            }
            css[hang][lei] = cs[i];
        }
        return null;
    }
}
