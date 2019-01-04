/**
 * @Author: WuFan
 * @Date: 2019/1/4 22:58
 */
/*
* 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。*/
package offer;

import java.util.ArrayList;
import java.util.Stack;

public class Solution6 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //用栈存储listnode的节点值，然后依次出栈
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }
}
