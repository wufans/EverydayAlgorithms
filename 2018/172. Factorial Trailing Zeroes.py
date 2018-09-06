# -*- coding: utf-8 -*-
"""
Created on Wed Sep  5 14:52:32 2018

@author: wufan
# =============================================================================
# Given an integer n, return the number of trailing zeroes in n!.
# 
# Example 1:
# 
# Input: 3
# Output: 0
# Explanation: 3! = 6, no trailing zero.
# Example 2:
# 
# Input: 5
# Output: 1
# Explanation: 5! = 120, one trailing zero.
# Note: Your solution should be in logarithmic time complexity.
# =============================================================================
"""
class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
# =============================================================================
        #超时算法
#         from functools import reduce
#         if n == 0:return 0
#         mul = reduce(lambda x,y:x*y,range(1,n+1))
#         #print(mul)
#         count = 0
# #        for _ in range(len(str(mul))):
# #            if str(mul)[len(str(mul))-1-_] =="0":
# #                count += 1
# #            else:
# #                return count
#         while(mul%10 ==0 and mul != 0):
#             count += 1
#             mul = mul / 10
#         return count
# =============================================================================
        
#1. meet the number that can be dived by 5, the Trailing will have 1 more zero.
#2 .meet the number that can be dived by 5*5, the Trailing will have 2 more zero.
        r = 0
        while n > 0:
            n /= 5
            r += n
        return r
print(Solution().trailingZeroes(7))
