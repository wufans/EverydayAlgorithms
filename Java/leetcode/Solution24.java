/**
 * @Author: WuFan
 * @Date: 2019/1/10 15:10
 */

package leetcode;

import leetcode.ListNode;

/*
* Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.*/
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        int temp = 0;
        ListNode tmp_node = head;
        while(tmp_node.next != null){
            if(temp == 0){
                int value = tmp_node.val;
                tmp_node.val = tmp_node.next.val;
                tmp_node.next.val = value;
                tmp_node = tmp_node.next;
                temp ++;
            }
            else{
                temp =0;
                tmp_node = tmp_node.next;
            }
        }
        return head;
    }
    //iterative solution
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = head;

        while(r != null && r.next != null){
            l.next = r.next;
            r.next = l.next.next;
            l.next.next = r;
            l = l.next.next;
            r = r.next;
        }
        return dummy.next;
    }
}
