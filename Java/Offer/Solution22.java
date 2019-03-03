/**
 * @Author: WuFan
 * @Date: 2019/3/3 23:06
 */

package offer;

import java.util.Stack;

/*
链表中倒数第 K 个结点
* 输入一个链表，输出该链表中倒数第k个结点。*/
public class Solution22 {
    public ListNode FindKthToTail(ListNode head,int k) {
//        if(k==0){
//            return null;  //主要考虑边界条件
//        }
//        Stack<ListNode> test = new Stack<>();
//        while(head != null){
//            test.push(head);
//            head = head.next;
//        }
//        for(int i = k;k > 1;k--){
//            if(!test.isEmpty())
//                test.pop();
//            else
//                return null;
//        }
//        if(test.isEmpty())
//            return null;
//        else
//            return test.pop();


        //更聪明的解法
        /*
        * 设链表的长度为 N。设两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K
        个节点可以移动。此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，
        P2 移动到 N - K 个节点处，该位置就是倒数第 K 个节点。*/
        if (head == null)
            return null;
        ListNode P1 = head;
        while (P1 != null && k-- > 0)
            P1 = P1.next;
        if (k > 0)
            return null;
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

}
