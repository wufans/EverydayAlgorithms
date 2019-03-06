/**
 * @Author: WuFan
 * @Date: 2019/3/6 20:41
 */

package offer;
/*
* 复杂链表的复制
* 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/

//这个题的思路非常有趣！！！！
//注意理解题的意思，注意什么事复杂链表，它指向的是链表中的任意一个节点，而不是链表外的另一个节点。
public class Solution35 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
// 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        } // 建立 random 链接
            cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        } // 拆分
            cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
