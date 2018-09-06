# -*- coding: utf-8 -*-
"""
Created on Thu Sep  6 17:06:01 2018

@author: wufan
# =============================================================================
# Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
# 
# Example 1:
# 
# Input: 11
# Output: 3
# Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
# Example 2:
# 
# Input: 128
# Output: 1
# Explanation: Integer 128 has binary representation 00000000000000000000000010000000
# =============================================================================
"""
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        for _ in str(bin(n))[2:]:
            if _ == "1":
                count += 1
        return count
    
# =============================================================================
#         result = 0
#         
#         while n:
#             result += n & 1
#             n = n >> 1
#         
#         return result
# =============================================================================
print(Solution().hammingWeight(11))
