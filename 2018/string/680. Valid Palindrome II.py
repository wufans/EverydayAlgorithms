# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
"""


class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """

        #time exceeded
        # if s == s[::-1]:
        #     return True
        # else:
        #     for i in range(len(s)):
        #         if s[:i]+s[i+1:] == (s[:i]+s[i+1:])[::-1]:
        #             return True
        # return False


        #beats 94%
        start = 0
        end = len(s)-1
        while(start<=end):
            if s[start] == s[end]:
                start += 1
                end -= 1
            else:
                return s[start+1:end+1] == s[start+1:end+1][::-1] \
                       or s[start:end] == s[start:end][::-1]
        return True


        # fastest solution 100% but similar thoughts
        # s2 = s[::-1]
        # if s == s2:
        #     return True
        # for i in range(len(s) // 2):
        #     if s[i] != s2[i]:
        #         if s[i + 1:len(s) // 2 + 1] == s2[i:len(s) // 2]:
        #             return True
        #         if s[i:len(s) // 2] == s2[i + 1:len(s) // 2 + 1]:
        #             return True
        #         return False
print(Solution().validPalindrome("abccbaaa"))
