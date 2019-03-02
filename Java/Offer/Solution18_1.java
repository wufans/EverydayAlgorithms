/**
 * @Author: WuFan
 * @Date: 2019/3/2 16:54
 */

package offer;
/*
* 在 O(1) 时间内删除链表节点
*
* 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该
节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
    否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向
null，时间复杂度为 O(N)。*/
public class Solution18 {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete){
        if(head == null || tobeDelete == null || head.next == null){
            return null;
        }
        if(tobeDelete.next != null){
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        }
        else{
            //ListNode test = head.next; //注意这样是有问题的，因为可能head.next == tobeDelete。
            ListNode test = head;
            while(test.next != tobeDelete){
                test = test.next;
            }
            test.next = null;
        }
        return head;
    }
}
