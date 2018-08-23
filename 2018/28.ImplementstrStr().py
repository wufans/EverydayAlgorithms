# -*- coding: utf-8 -*-
"""
Created on Thu Aug 23 17:19:02 2018

@author: wufan

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
"""
class Solution:
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
#   my solution -1
# =============================================================================
#         if not needle: return 0
#         if not haystack: return -1
#     
#         if len(haystack) < len(needle):return -1
#         for i in range(len(haystack)):
#             print(i)
#             if haystack[i] == needle[0]:
#                 for j in range(len(needle)):
#                     if i+j >= len(haystack):
#                         return -1
#                     elif haystack[i+j] != needle[j]:
#                         break
#                     elif j == len(needle) - 1:
#                         return i
#         return -1
# =============================================================================
    
# Good solution examples -- 2
        
        for i in range(len(haystack) - len(needle)+1):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1
# =============================================================================
# solution 3
#         if len(n) == 0: return 0
#         return int(len(h.split(n)[0])) if len(h.split(n)[0])!=len(h) else -1
# =============================================================================

test = Solution().strStr("df","")
print(test)
        
