"""
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
"""

class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        # return sorted(s) == sorted(t)
        
        if len(s) != len(t):
            return False
        # count() 方法用于统计某个元素在列表中出现的次数。
        for char in set(s):
            if s.count(char) != t.count(char):
                return False
        return True
