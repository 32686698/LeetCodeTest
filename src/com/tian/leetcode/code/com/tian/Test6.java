package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 */
public class Test6 {

    public static void main(String[] args) {
        Test6 t = new Test6();
        String s = t.convert("ABCDE",5);
        System.out.println(s);
    }

    /**
     * 我的实现
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(s.length()<=numRows||numRows==1)
            return s;
        int zqgsdw = numRows*2-2;   //周期个数单位 ，一个周期有几个字符
        int zqlsdw = numRows-1;     //周期列数单位 ，一个周期有几列
        char[] cs = s.toCharArray();
        char[][] css = new char[numRows][(s.length()/zqgsdw+1) * zqlsdw];
        for(int i = 0 ; i < cs.length;i ++){
            int zqs = i/zqgsdw+1;//周期数
            int zqgs = i%zqgsdw+1;//周期里的个数
            int zhouqilei = 1;
            if(zqgs>numRows){
                zhouqilei += zqgs - numRows;
            }
            int lei = zqlsdw * (zqs-1) + zhouqilei;

            int hang = zqgs;
            if(zqgs>numRows){
                hang = numRows - (zqgs - numRows);
            }
            css[hang-1][lei-1] = cs[i];
        }
        StringBuffer sb = new StringBuffer();
        for(char[] cc : css){
            for(char c:cc){
                if(c!=0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }


    /**
     * 牛逼的实现 不太理解
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if(numRows==1||numRows==0){return s;}
        int cha = 2*numRows-2;
        char[] chars = new char[s.length()];
        int k=0;
        for(int i=0;i<numRows;i++){
            for(int j=i;j<chars.length;j+=cha){
                chars[k++] = s.charAt(j);
                if(i!=0&&i!=numRows-1&&j+cha-2*i<chars.length){
                    chars[k++] = s.charAt(j+cha-2*i);
                }
            }
        }
        return String.valueOf(chars);
    }
}
