# -*- coding: utf-8 -*-
"""
Created on Tue Sep 18 17:37:53 2018

@author: wufan

# =============================================================================
# Given an integer, write a function to determine if it is a power of two.
# 
# Example 1:
# 
# Input: 1
# Output: true 
# Explanation: 20 = 1
# Example 2:
# 
# Input: 16
# Output: true
# Explanation: 24 = 16
# Example 3:
# 
# Input: 218
# Output: false
# =============================================================================
"""
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
#        if n <= 0:return False
#        if n == 1:return True
#        while n != 1:
#            tmp = n % 2
#            if tmp != 0:return False
#            if n == 1:return True
#            n = n/2
#        return True
        if n <= 0:return False
        return n&(n-1) == 0
print(Solution().isPowerOfTwo(16))
            
