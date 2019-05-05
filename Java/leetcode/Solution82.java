/**
 * @Author: WuFan
 * @Date: 2019/5/5 9:21
 */

package leetcode;
/*
* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*/
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        /*beats 100%*/
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        while(next != null && next.val == head.val){
            next = next.next;
        }

        if(head.next == next){
            head.next = deleteDuplicates(next);
            return head;
        }else{
            return deleteDuplicates(next);
        }

    }
}
