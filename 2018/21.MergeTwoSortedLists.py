# -*- coding: utf-8 -*-
"""
Created on Wed Aug 22 09:57:14 2018

@author: wufan

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
"""
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1 and not l2:return None
        #result_l = l1 if l1.val <= l2.val else l2
        result_l = ListNode(0)
        #result_l.next = None
        tmp = result_l
        while(l1 != None and l2 != None):
            if l1.val <= l2.val:
                tmp.next = l1
                l1 = l1.next
            else:
                tmp.next = l2
                l2 = l2.next
            tmp = tmp.next
            #print(tmp.val)
        #如果l1或者l2有一个不为None，则拼接在tmp后面
        tmp.next = l1 or l2
        return result_l.next
                
# Definition for singly-linked list
        
l1 = ListNode(1)
b= ListNode(2)
c = ListNode(4)
l1.next = b
b.next = c

l2 = ListNode(1)
d= ListNode(3)
e = ListNode(4)
l2.next = d
d.next = e

test = Solution()
result = test.mergeTwoLists(l1,l2)
#result = l1
while(result!= None):
    print(result.val)
    result = result.next
 
