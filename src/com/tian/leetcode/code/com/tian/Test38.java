package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/count-and-say/description/
 */
public class Test38 {

    public static  void main(String[] args){
        Test38 t = new Test38();
        String tt = t.countAndSay(4);
        System.out.println(tt);
    }

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String re = "11";
        for (int i = 2; i <= n ; i++) {
            String cre = "";
            char[] chars = re.toCharArray();
            for (int j = 1; j <= chars.length;) {
                if(chars[j-1]!=chars[j]){
                    if(chars[j-1]=='1'){
                        cre += "11";
                    }else{
                        cre += "12";
                    }
                    j += 1;
                }else{
                    if(chars[j-1]=='1'){
                        cre += "21";
                    }else{
                        cre += "22";
                    }
                    j += 2;
                }
            }
            re = cre;
        }
        return re;
    }
}
