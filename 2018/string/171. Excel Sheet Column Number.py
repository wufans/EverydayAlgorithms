# -*- coding: utf-8 -*-
"""
Created on Wed Sep  5 14:31:15 2018

@author: wufan
# =============================================================================
# Given a column title as appear in an Excel sheet, return its corresponding column number.
# 
# For example:
# 
#     A -> 1
#     B -> 2
#     C -> 3
#     ...
#     Z -> 26
#     AA -> 27
#     AB -> 28 
#     ...
# Example 1:
# 
# Input: "A"
# Output: 1
# Example 2:
# 
# Input: "AB"
# Output: 28
# Example 3:
# 
# Input: "ZY"
# Output: 701
# =============================================================================
"""

class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:return None
        result = 0
        for i,cha in enumerate(list(s)):
            result += (ord(cha)-64)*pow(26,len(s)-1-i)
        return result
print(Solution().titleToNumber("ZY"))
# =============================================================================
#         count = 0
#         start = ord('A')-1
#         for c in s:
#             count = count*26
#             count = ord(c) - start + count
#         return count
# =============================================================================
