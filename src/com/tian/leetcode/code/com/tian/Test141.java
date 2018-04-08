package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;
import com.tian.leetcode.code.com.tian.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test141 {

    public static void main(String[] args){
        ListNode node1=new ListNode(1, null);
        ListNode node2=new ListNode(2, node1);
        ListNode node3=new ListNode(3, node2);

        ListNode node4=new ListNode(4, node3);
        ListNode node5=new ListNode(5, node4);
        ListNode node6=new ListNode(6, node5);

        ListNode node7=new ListNode(7, node6);

//        node1.next = node7;

        Test141 t = new Test141();
        boolean b = t.hasCycle(node1);
        System.out.println(b);
    }


    /**
     * 我的实现
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (null!=current){
            if(listNodes.contains(current)){
                return true;
            }
            listNodes.add(current);
            current = current.next;
        }
        return false;
    }

    /**
     * 牛逼的实现
     * 默认它是个圈
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
