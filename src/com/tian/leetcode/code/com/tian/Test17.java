package com.tian.leetcode.code.com.tian;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class Test17 {
    public static void main(String[] args) {
        Test17 t = new Test17();
        List list = t.letterCombinations("23456789");
        System.out.println(list);
    }


    /**
     * 我的实现
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<String,String[]> map = new HashMap<>();
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});

        char[] cs = digits.toCharArray();
        List<String> current = new ArrayList<>();
        List<String> last = new ArrayList<>();
        for(int i = 0 ; i < cs.length; i ++){
            String[] aa = map.get(cs[i]+"");
            if(i==0){
                last.addAll(Arrays.asList(aa));
            }else {
                for (String str : aa) {
                    for (String res : last) {
                        res += str;
                        current.add(res);
                    }
                }
                last = current;
                current = new ArrayList<>();
            }
        }
        return last;
    }
}
