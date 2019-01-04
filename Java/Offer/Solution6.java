/**
 * @Author: WuFan
 * @Date: 2019/1/4 22:58
 */
/*
* 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。*/
package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution6 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //用栈存储listnode的节点值，然后依次出栈
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }
    //使用递归
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }
    //头插法
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }
    //Collections.reverse()
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (listNode != null) {
            ret.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(ret);
        return ret;
    }
}
