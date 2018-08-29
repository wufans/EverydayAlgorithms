# -*- coding: utf-8 -*-
"""
Created on Wed Aug 29 23:01:43 2018

@author: WuFan

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:return head
        tmp = head
        while(tmp.next != None):
            if tmp.next.val == tmp.val:
                tmp.next = tmp.next.next
            else:
                tmp = tmp.next
        return head
# =============================================================================
#         if not head: # noy head = head is None:
#             return head
#         current = head
#         while current.next: # while head.next = head.next is none
#             if current.next.val == current.val:
#                 current.next = current.next.next
#             else:
#                 current = current.next
#         return head
# =============================================================================
