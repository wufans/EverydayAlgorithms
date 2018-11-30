# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.



Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

"""


class Solution(object):
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """

        # time exceed
        # if not s:return False
        # length = len(s)
        # for i in range(1,length // 2 +1):
        #     sub = s.count(s[:i])
        #     #print(i,sub,length)
        #
        #     if sub * i== length:
        #         return True
        # return False

        #5%
        # if not s: return False
        # length = len(s)
        # for i in range(1,length // 2 +1):
        #     print(i,s[:i])
        #     if s[:i]*(length//i) == s:
        #         return True
        # return False
        if not s: return False
        ss = (s + s)[1:-1]  # remove the first and last characters of ss
        return ss.find(s) != -1


print(Solution().repeatedSubstringPattern("abcabcabcabc"))
