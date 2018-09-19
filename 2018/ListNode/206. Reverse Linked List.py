# -*- coding: utf-8 -*-
"""
Created on Sat Sep 15 11:55:51 2018


@author: wufan
# =============================================================================
# Reverse a singly linked list.
# 
# Example:
# 
# Input: 1->2->3->4->5->NULL
# Output: 5->4->3->2->1->NULL
# Follow up:
# 
# A linked list can be reversed either iteratively or recursively. Could you implement both?
# =============================================================================
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        prev = None
        while head:
            curr = head
            head = head.next
            curr.next = prev
            prev = curr
        return prev
    
    
# =============================================================================
#         return self._reverse(head)
# 
#     def _reverse(self, node, prev=None):
#         if not node:
#             return prev
#         n = node.next
#         node.next = prev
#         return self._reverse(n, node)
# 
# =============================================================================
