# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
"""


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
#40%
    #     self.n = n
    #     self.flag = False
    #     self.findx(head)
    #     if self.flag:
    #         return head
    #     else:
    #         return head.next
    # def findx(self,node):
    #     if node.next == None:
    #         number = 1
    #     else:
    #         number = self.findx(node.next) + 1
    #     if number == self.n + 1:
    #         node.next = node.next.next
    #         self.n = -2
    #         self.flag = True
    #     return number

        """
        维护一个长度为N的滑动窗口！！！
        """
        # 用两个指针来帮助我们解题，pre和cur指针。首先cur指针先向前走N步，如果此时cur指向空，
        # 说明N为链表的长度，则需要移除的为首元素，那么此时我们返回head->next即可，
        # 如果cur存在，我们再继续往下走，此时pre指针也跟着走，直到cur为最后一个元素时停止，
        # 此时pre指向要移除元素的前一个元素，我们再修改指针跳过需要移除的元素即可
        dummy = prev = ListNode(0)
        prev.next = head
        fast = head

        while n > 0:
            fast = fast.next
            n -= 1
        while fast:
            fast = fast.next
            prev = prev.next
        next = prev.next
        prev.next = next.next
        del next

        return dummy.next

