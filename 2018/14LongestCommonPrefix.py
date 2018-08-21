# -*- coding: utf-8 -*-
"""
Created on Tue Aug 21 22:06:16 2018

@author: WuFan

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

注意两个对字符串的操作：
>>> max(["flower","flow","flight"])
'flower'
>>> min(["flower","flow","flight"])
'flight'
"""
class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:return ""
        min_s = min(strs)
        max_s = max(strs)
        if not min_s:return ""
        for (i,v) in enumerate(min_s):
            if max_s[i] != min_s[i]:
                return max_s[:i]
        return min_s[:]
        
        """
        if not strs:
            return ""
        shortest = min(strs,key=len)
        for i, ch in enumerate(shortest):
            for other in strs:
                if other[i] != ch:
                    return shortest[:i]
        return shortest
        """
test = Solution()
print(test.longestCommonPrefix(["flower","flow","flight"]))
