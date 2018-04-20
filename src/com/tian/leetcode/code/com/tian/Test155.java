package com.tian.leetcode.code.com.tian;

public class Test155 {


    public static void main(String[] args){
        Test155 minStack  = new Test155();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }


    private ListNode head;
    private ListNode listNode ;

    public Test155() {
    }

    public void push(int x) {
        if(null==listNode){
            listNode = new ListNode(x);
            head = listNode;
        }else{
            ListNode lastNode = listNode;
            listNode.next=new ListNode(x);
            listNode = listNode.next;
            listNode.last = lastNode;
        }
    }

    public void pop() {
        if(null==listNode){
            return;
        }
        listNode = listNode.last;
        if(listNode!=null) {
            listNode.next = null;
        }
    }

    public int top() {
        return listNode.val;
    }

    public int getMin() {
        ListNode cHead = head;
        int min = cHead.val;
        while (cHead!=null){
            min = Math.min(min,cHead.val);
            cHead = cHead.next;
        }
        return min;
    }
    private class ListNode {
        public int val;
        public ListNode next;
        public ListNode last;
        public ListNode(int x) {
            val = x;
        }
    }

}
