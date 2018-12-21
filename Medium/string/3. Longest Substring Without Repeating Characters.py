# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
"""


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        #time exceeded
        # res = 0
        # for i in range(len(s)):
        #     for j in range(i,len(s)+1):
        #         if len(set(list(s[i:j]))) == len(list(s[i:j])):
        #             res = max(res,j-i)
        #         else:
        #             break
        # return res

        start = maxLength = 0
        usedChar = {}
        for i in range(len(s)):
            if s[i] in usedChar and start <= usedChar[s[i]]:
                start = usedChar[s[i]] + 1
            else:
                maxLength = max(maxLength, i - start + 1)

            usedChar[s[i]] = i

        return maxLength

print(Solution().lengthOfLongestSubstring(" "))
