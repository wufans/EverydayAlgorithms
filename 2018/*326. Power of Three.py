# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
"""
class Solution:
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        # 1162261467 is 3^19,  3^20 is bigger than int
        return n > 0 and 1162261467 % n == 0
        # while n > 1:
        #     n /= 3
        # return n == 1
