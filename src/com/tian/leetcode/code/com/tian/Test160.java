package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class Test160 {

    public static void main(String[] args){
        ListNode a = ListNode.getIns(1,3,5,7,9,11,13,9955,9957,9959,9961,9963,9965,9967,9969,9971,9973,9975,9977,9979,9981,9983,9985,9987,9989,9991,9993,9995,9997,9999,10000);
        ListNode b = ListNode.getIns(2,4,6,8,10,12,9950,9952,9954,9956,9958,9960,9962,9964,9966,9968,9970,9972,9974,9976,9978,9980,9982,9984,9986,9988,9990,9992,9994,9996,9998,10000);
        ListNode c = new Test160().getIntersectionNode(a,b);
        System.out.println(c.toString());
    }


    /**
     * 我的实现
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        ListNode currentA = headA;
        while (null!=currentA){
            a.add(currentA.val);
            currentA = currentA.next;
        }
        while (null!=headB){
            b.add(headB.val);
            headB = headB.next;
        }
        int re = -1;
        for (int i = a.size()-1,j = b.size()-1;i >= 0; i--,j--){
            if(j>=0){
                if(a.get(i).equals(b.get(j))){
                    re = i;
                }else{
                    break;
                }
            }
        }
        if(re==-1){
            return null;
        }
        int i = 0 ;
        while(i!=re){
            headA = headA.next;
            i ++;
        }
        return headA;
    }


    /**
     * 牛逼的实现
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int aLen = 0,bLen = 0;
        ListNode curA = headA,curB = headB;
        while (curA != null) {
            aLen++;
            curA = curA.next;
        }
        while (curB != null){
            bLen++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if(aLen > bLen){
            for (int i = aLen - bLen; i > 0; i--) {
                curA = curA.next;
            }
        }else{
            for (int i = bLen - aLen; i > 0; i--) {
                curB = curB.next;
            }
        }

        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }



}
