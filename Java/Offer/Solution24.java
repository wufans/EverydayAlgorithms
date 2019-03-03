/**
 * @Author: WuFan
 * @Date: 2019/3/3 23:56
 */

package offer;

import java.util.Stack;

/*反转链表
* 输入一个链表，反转链表后，输出新链表的表头。*/
public class Solution24 {
    public ListNode ReverseList(ListNode head) {

//        if(head == null || head.next == null){
//            return head;
//        }
//        Stack<ListNode> temp = new Stack<>();
//        while(head != null){
//            temp.push(head);
//            head = head.next;
//        }
//        head = temp.pop();
//        ListNode t = head;
//        while(!temp.isEmpty()){
//            t.next = temp.pop();
//            t = t.next;
//        }
//        return head;
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next);
        next.next = head;
        return newHead;
    }


}
