# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
"""


class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        # res = ""
        # for x in s.split(" "):
        #     res += x[::-1]+" "
        # return res.strip()
        a = map(lambda x: x[::-1], s.split())
        return ' '.join(a)
print(Solution().reverseWords("Let's take LeetCode contest"))
