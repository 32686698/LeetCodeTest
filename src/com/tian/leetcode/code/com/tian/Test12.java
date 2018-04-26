package com.tian.leetcode.code.com.tian;

public class Test12 {

    public static void main(String[] args) {
        Test12 t = new Test12();
        String s = t.intToRoman(3);
        System.out.println(s);
        s = t.intToRoman(4);
        System.out.println(s);
        s = t.intToRoman(9);
        System.out.println(s);
        s = t.intToRoman(58);
        System.out.println(s);
        s = t.intToRoman(1994);
        System.out.println(s);
        s = t.intToRoman(100);
        System.out.println(s);
    }

    /**
     * 我的实现
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        boolean is4 = true, is9 = true, is40 = true, is90 = true, is400 = true, is900 = true;
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 900) {
                if (is900) {
                    sb.append("CM");
                    num -= 900;
                    is900 = false;
                }
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;
            } else if (num >= 400) {
                if (is400) {
                    sb.append("CD");
                    num -= 400;
                    is400 = false;
                }
            } else if (num >= 100) {
                sb.append("C");
                num -= 100;
            } else if (num >= 90) {
                if (is90) {
                    sb.append("XC");
                    num -= 90;
                    is90 = false;
                }
            } else if (num >= 50) {
                sb.append("L");
                num -= 50;
            } else if (num >= 40) {
                if (is40) {
                    sb.append("XL");
                    num -= 40;
                    is40 = false;
                }
            } else if (num >= 10) {
                sb.append("X");
                num -= 10;
            } else if (num >= 9) {
                if (is9) {
                    sb.append("IX");
                    num -= 9;
                    is9 = false;
                }
            } else if (num >= 5) {
                sb.append("V");
                num -= 5;
            } else if (num >= 4) {
                if (is4) {
                    sb.append("IV");
                    is4 = false;
                    num -= 4;
                }
            } else if (num < 4) {
                sb.append("I");
                num -= 1;
            }
        }

        return sb.toString();
    }

    /**
     * 更快的实现
     */
    private final String[][] SYNBOL = new String[][]{
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}};

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(SYNBOL[3][num / 1000 % 10]);
        sb.append(SYNBOL[2][num / 100 % 10]);
        sb.append(SYNBOL[1][num / 10 % 10]);
        sb.append(SYNBOL[0][num % 10]);
        return sb.toString();
    }
}
