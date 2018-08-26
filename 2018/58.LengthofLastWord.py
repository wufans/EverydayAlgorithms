# -*- coding: utf-8 -*-
"""
Created on Sun Aug 26 22:06:22 2018

@author: wufan

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
"""
class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
# My solution
# =============================================================================
#         result = s.split(" ")
#         print(-len(result)-1)
#         for i in range(-1,-len(result)-1,-1):
#             #print(i)
#             if len(result[i]) != 0:
#                 return len(result[i]) 
#         return 0
# =============================================================================
#   good solution
        return len(s.rstrip().split(' ')[-1])

print(Solution().lengthOfLastWord("Hello World"))
