# -*- coding: utf-8 -*-
# @Time    : 2018/12/20 23:42
# @Author  : wufan
# @Email   : wufan123321@gmail.com
"""
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # n1 = 0
        # n2 = 0
        # m1 = 1
        # m2 = 1
        # while l1:
        #     tmp = l1.val
        #     n1 += m1 * tmp
        #     m1 *= 10
        #     l1 = l1.next
        # while l2:
        #     tmp = l2.val
        #     n2 += m2 * tmp
        #     m2 *= 10
        #     l2 = l2.next
        # R = []
        # M = n1 + n2
        # R = list(map(int, str(M)))
        # R = R[::-1]
        # return R
        carry = 0
        pre_l1 = None
        head = l1
        while (l1 != None and l2 != None):
            tmp_sum = l1.val + l2.val + carry
            carry = int((tmp_sum) / 10)
            l1.val = (tmp_sum) % 10

            pre_l1 = l1
            l1, l2 = l1.next, l2.next

        if l2 != None:
            pre_l1.next = l2
            l1 = pre_l1.next

        while l1 != None and carry == 1:
            tmp_sum = l1.val + carry
            l1.val = (tmp_sum) % 10
            carry = int((tmp_sum) / 10)
            pre_l1, l1 = l1, l1.next

        if carry == 1:
            pre_l1.next = ListNode(1)

        return head
