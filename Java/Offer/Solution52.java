/**
 * @Author: WuFan
 * @Date: 2019/3/17 11:21
 */

package offer;

import java.util.Stack;

/*
* 两个链表的第一个公共结点
* 输入两个链表，找出它们的第一个公共结点。*/
public class Solution52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode>  s1 = new Stack<>();
        Stack<ListNode>  s2 = new Stack<>();
        while(pHead1!=null){
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode res = null;
        while(s1.size()>0 && s2.size()>0){
            if(s1.peek() == s2.peek()){
                s1.pop();
                res = s2.pop();
            }else{
                return res;
            }

        }
        return res;
    }

    //双指针的解法
    /*设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c
    + b = b + c + a。
    当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表
    B；同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开
    始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。*/
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

}
