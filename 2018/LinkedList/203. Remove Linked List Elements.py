
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 11 16:31:24 2018

@author: wufan
# =============================================================================
# Remove all elements from a linked list of integers that have value val.
# 
# Example:
# 
# Input:  1->2->6->3->4->5->6, val = 6
# Output: 1->2->3->4->5
# 
# =============================================================================
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        next = dummy

        while next != None and next.next != None:
            if next.next.val == val:
                next.next = next.next.next
            else:
                next = next.next
        return dummy.next
        
    
# =============================================================================
#         if not head:return None
#         
# #         #MOVE THE HEADS AS LONG AS NECESSARY
# #         while head and head.val==val:
# #             head=head.next
#             
# #         curr=head
# #         while curr!=None and curr.next!=None:
#             
# #             #STANDARD
# #             if curr.next.val==val:
# #                 curr.next=curr.next.next
#             
# #             #SPECIAL, NEED TO MAINTIAN CURRENT POINTER AS LONG AS NEXT ONE IS VAL
# #             #CHECK IF CURR.NEXT EXISTS BEFORE ACCESSING ITS VAL
# #             #SINCE WE CHECK FOR THE ABOVE CONDITION IN THE LOOP, AND INCREMENT IT ABOVE
# #             #WE NEED TO CHECK AGAIN
# #             if curr.next and curr.next.val!=val:
# #                 curr=curr.next
#         
# 
#             
# #         return head
# 
#         
#         oghead=head
#         prev=None
#         
#         
#         #remove from beginning
#         while head:
#             
#             if head.val==val:
#                 head=head.next
#             
#             else:break
#                 
#         #invariant that arrive at first non val element
#         oghead=head
#         
#         if head:
#             curr=head.next
#             prev=head
# 
# 
# 
#             while curr:
# 
#                 if curr.val==val:
#                     prev.next=curr.next
#                 else:
#                     prev=curr
# 
# 
#                 curr=curr.next
# 
#         return oghead
# =============================================================================
