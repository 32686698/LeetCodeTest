package com.tian.leetcode.code.com.tian;

public class Test43 {

    public static void main(String[] args) {
        Test43 t = new Test43();
        String a = t.multiply("999999999999999999","1");
        System.out.println(a);
    }


    public String multiply(String num1, String num2) {
        char [] cs1 = num1.toCharArray();
        char [] cs2 = num2.toCharArray();
        String[] nums = new String[cs1.length];
        int k = 0;
        String s0 = "";
        for(int i = cs1.length-1;i>=0;i--){
            int jinwei = 0;
            StringBuffer result = new StringBuffer(s0);
            for(int j = cs2.length-1;j>=0;j--){
                int a = Integer.parseInt(cs1[i]+"")*Integer.parseInt(cs2[j]+"")+jinwei;
                result.append(a%10);
                jinwei = a/10;
            }
            if(jinwei>0)
                result.append(jinwei);
            nums[k++] = result.toString();
            s0 += "0";
        }
        int overS = 0;
        StringBuffer result = new StringBuffer();
        int jinwei = 0;
        for(int i = 0;;i++){
            int count = jinwei;
            for (int j = 0 ;j < nums.length;j++){
                if(nums[j].length()==i){
                    overS ++;
                }else if(nums[j].length()>i){
                    count += Integer.parseInt(nums[j].charAt(i)+"");
                }
            }
            if(overS==nums.length)
                break;
            result.append(count%10);
            jinwei = count/10;
        }
        if(jinwei>0){
            while (jinwei>0){
                result.append(jinwei%10);
                jinwei = jinwei/10;
            }
        }
        StringBuffer result2 = new StringBuffer();
        for (int j = result.length()-1;j>=0;j--){
            result2.append(result.charAt(j));
        }
        if(result2.toString().replace("0","").equals(""))
            return "0";
        return result2.toString();
    }
}
