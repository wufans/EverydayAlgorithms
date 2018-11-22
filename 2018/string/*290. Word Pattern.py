# -*- coding: utf-8 -*-
#@author: WuFan
"""Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false"""
class Solution:
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        # very slow
        # pattern = list(pattern)
        # str = str.split(" ")
        # if len(pattern) != len(str):
        #     return False
        # if len(pattern) <= 1:
        #     return True
        #
        # for i in range(len(pattern)-1):
        #     for j in range(i+1,len(pattern)):
        #         if not (pattern[i] == pattern[j]) == (str[i]==str[j]):
        #             return False
        # return True
# Good idea
        return len(set(zip(pattern, str.split()))) == len(set(pattern)) == len(set(str.split())) and len(
            pattern) == len(str.split())
pattern = "abba"
str = "dog cat cat a"

print(Solution().wordPattern(pattern,str))
