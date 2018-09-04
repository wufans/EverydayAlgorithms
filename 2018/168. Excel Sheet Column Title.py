# -*- coding: utf-8 -*-
"""
Created on Tue Sep  4 09:04:09 2018

@author: wufan

# =============================================================================
# Given a positive integer, return its corresponding column title as appear in an Excel sheet.
# 
# For example:
# 
#     1 -> A
#     2 -> B
#     3 -> C
#     ...
#     26 -> Z
#     27 -> AA
#     28 -> AB 
#     ...
# Example 1:
# 
# Input: 1
# Output: "A"
# Example 2:
# 
# Input: 28
# Output: "AB"
# Example 3:
# 
# Input: 701
# Output: "ZY"
# =============================================================================
"""
class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        capitals = [chr(x) for x in range(ord('A'), ord('Z')+1)]
        result = []
        while n > 0:
            result.append(capitals[(n-1)%26])
            n = (n-1) // 26
        result.reverse()
        return ''.join(result)
print(Solution().convertToTitle(702))