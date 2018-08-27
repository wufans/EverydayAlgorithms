# -*- coding: utf-8 -*-
"""
Created on Mon Aug 27 09:47:18 2018

@author: wufan

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
"""
class Solution:
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
# =============================================================================
#        my solution
#         return bin(int(a,2)+int(b,2)).replace('0b','')
# =============================================================================
#        return bin(eval('0b' + a) + eval('0b' + b))[2:]
        return bin(int(a,2)+int(b,2))[2:]
print(Solution().addBinary("1010","1011"))
