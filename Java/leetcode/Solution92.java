/**
 * @Author: WuFan
 * @Date: 2019/5/12 10:29
 */

package leetcode;
/*
* Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL*/
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++)
            pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
    }



    //注意理解题目意思，是逆转这部分listnode，而不是依次替换！
    public ListNode reverseBetween_wrong(ListNode head, int m, int n) {
        int start = 1;
        ListNode res_Head = head;
        //当前指向需要reverse的第一个节点的前一个节点
        while(m>start+1){
            head = head.next;
            start++;
        }
        //reverse从m到n的所有节点
        while(m<n && head.next.next != null){
            ListNode current = head.next;//节点m
            head.next = current.next;
            current.next = head.next.next;
            head.next.next = current;
            head = head.next;
            m++;
        }
        return res_Head;
    }
}
