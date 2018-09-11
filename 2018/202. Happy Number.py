# -*- coding: utf-8 -*-
"""
Created on Tue Sep 11 16:04:12 2018

@author: wufan
# =============================================================================
# Write an algorithm to determine if a number is "happy".
# 
# A happy number is a number defined by the following process: Starting with any 
positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), or it 
loops endlessly in a cycle which does not include 1. Those numbers for which 
this process ends in 1 are happy numbers.
# 
# Example: 
# 
# Input: 19
# Output: true
# Explanation: 
# 12 + 92 = 82
# 82 + 22 = 68
# 62 + 82 = 100
# 12 + 02 + 02 = 1
# =============================================================================
"""
class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n ==1:return True
        tmp = []
        while not n in tmp:
            tmp_num = 0
            #print(tmp)
            tmp.append(n)
            if n == 1:
                return True
            for i in str(n):
                tmp_num += pow(int(i),2) 
            n = tmp_num
        return False
    
# =============================================================================
#         while n!=1:
#             sums=0
#             while n > 0:
#                 num=n%10
#                 sums+=num**2
#                 n=n//10
#             if sums == 11 or sums == 20:
#                 return False
#             n=sums
#         return True
# =============================================================================
print(Solution().isHappy(10))
