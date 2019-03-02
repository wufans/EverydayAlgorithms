/**
 * @Author: WuFan
 * @Date: 2019/3/2 17:16
 */

package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* 删除链表中重复的结点*/
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 注意，链表是有序的！！！！！！！！！
public class Solution18_2 {
    public static ListNode deleteDuplication(ListNode pHead){

        //简单粗暴的方法，如果链表不是有序的话
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode current = pHead;

        while(current != null){
            if(map.containsKey(current.val)){
                map.put(current.val,map.get(current.val)+1);
            }else{
                map.put(current.val,1);
            }
            if(current.next == null){
                break;
            }else{
                current = current.next;
            }
        }
        while(map.get(pHead.val)>1){
            if(pHead.next != null){
                pHead = pHead.next;
            }
            else{
                return null;
            }
        }
        current = pHead;
        while(current.next!=null){
            while(map.get(current.next.val)>1){
                if(current.next.next != null){
                    current.next = current.next.next;
                }else{
                    current.next = null;
                    return pHead;
                }
            }
            current = current.next;
        }
        return pHead;

        //可以用回溯法来做
//        if (pHead == null || pHead.next == null)
//            return pHead;
//        ListNode next = pHead.next;
//        if (pHead.val == next.val) {
//            while (next != null && pHead.val == next.val)
//                next = next.next;
//            return deleteDuplication(next);
//        } else {
//            pHead.next = deleteDuplication(pHead.next);
//            return pHead;
//        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(8);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(10);
        a.next = b;
        b.next = c;
        c.next = d;
        deleteDuplication(a);
    }
}
