/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        //递归版本
        // if(head == null || head.next == null){
        //     return head;
        // }
        // ListNode nextHead = head.next;
        // head.next = null;
        // ListNode reverseHead = reverseList(nextHead);
        // nextHead.next = head;
        // return reverseHead;
        
        //非递归版本
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
        
    }
}
