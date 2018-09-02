# -*- coding: utf-8 -*-
"""
Created on Sun Sep  2 16:04:05 2018

@author: wufan
# =============================================================================
# Given a linked list, determine if it has a cycle in it.
# 
# Follow up:
# Can you solve it without using extra space?
# =============================================================================
"""



class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head:return False
        while head.next:
            if head.next.val == -99999999:
                return True
            head.val = -99999999
            head = head.next
            
        return False
                
