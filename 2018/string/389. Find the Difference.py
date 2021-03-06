# -*- coding: utf-8 -*-
#@author: WuFan

"""
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
"""


class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        # a, b = sorted(s), sorted(t)
        # for index in range(len(s)):
        #     if a[index] != b[index]:
        #         return b[index]
        # return b[-1]

        # fastest method
        # base = "abcdefghijklmnopqrstuvwxyz"
        #
        # for b in base:
        #     if s.count(b) != t.count(b):
        #         return b

        total = 0
        for c in s:
            total += ord(c)
        for c in t:
            total -= ord(c)
        return chr(-total)
print(Solution().findTheDifference(s = "abcd",t = "abcde"))
