/**
 * @Author: WuFan
 * @Date: 2019/3/4 9:37
 */

package offer;
/*
* 合并两个排序的链表
* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。*/
public class Solution25 {
    public ListNode Merge(ListNode list1,ListNode list2) {

//        ListNode head = new ListNode(0);
//        ListNode HEAD = head;
//        while(list1 != null && list2 != null){
//            if(list1.val <= list2.val){
//                HEAD.next = list1;
//                HEAD = HEAD.next;
//                list1 = list1.next;
//            }else{
//                HEAD.next = list2;
//                list2 = list2.next;
//                HEAD = HEAD.next;
//            }
//        }
//        if(list1 != null){
//            HEAD.next = list1;
//        }
//        else if(list2 != null){
//            HEAD.next = list2;
//        }
//        return head.next;


        //用递归的方法做
        if(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ListNode head = list1;
                head.next = Merge(list1.next,list2);
                return head;
            }else{
                ListNode head = list2;
                head.next = Merge(list1,list2.next);
                return head;
            }
        }else if(list1 != null){
            return list1;
        }else if(list2 != null){
            return list2;
        }else{
            return null;
        }
    }
}
