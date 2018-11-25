# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
"""


class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        #  time exceeded
        # if len(s) == 0:
        #     return -1
        # for index in range(len(s)):
        #     if s.count(s[index]) == 1:
        #         return index
        # return -1


        # beats 4%
        # if s == "":
        #     return -1
        # for index in range(len(s)-1):
        #     if not s[index] in s[:index] and not s[index] in s[index+1:]:
        #         return index
        # if not s[-1] in s[:-1]:
        #     return len(s)-1
        # return -1


        #shortest execute time
        # m = len(s)
        # for c in "abcdefghijklmnopqrstuvwxyz":
        #     if s.find(c) != -1 and s.find(c) == s.rfind(c):
        #         m = min(m, s.find(c));
        # if m != len(s):
        #     return m;
        # return -1;

        # beats 34%
        if s == "":
            return -1
        for x in s:
            if s.find(x) == s.rfind(x):
                return s.find(x)
        return -1

print(Solution().firstUniqChar("leetcode"))
