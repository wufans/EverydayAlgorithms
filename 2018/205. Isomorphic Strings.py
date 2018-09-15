# -*- coding: utf-8 -*-
"""
Created on Fri Sep 14 14:25:23 2018

@author: wufan
# =============================================================================
# Given two strings s and t, determine if they are isomorphic.
# 
# Two strings are isomorphic if the characters in s can be replaced to get t.
# 
# All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
# 
# Example 1:
# 
# Input: s = "egg", t = "add"
# Output: true
# Example 2:
# 
# Input: s = "foo", t = "bar"
# Output: false
# Example 3:
# 
# Input: s = "paper", t = "title"
# Output: true
# =============================================================================
"""

class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if s == None or t== None:
            return False
        if len(s) != len(t):
            return False
        r1 = []
        r2 = []
        for i in range(len(s)):
            if not s[i] in r1:
                r1.append(s[i])
                if not t[i] in r2:
                    r2.append(t[i])
                else:
                    return False
            else:
                index_s = r1.index(s[i])
                if r2[index_s] == t[i]:
                    #return True
                    pass
                else:
                    return False
        return True
    
# =============================================================================
#     
#     def isIsomorphic1(self, s, t):
#         d1, d2 = {}, {}
#         for i, val in enumerate(s):
#             d1[val] = d1.get(val, []) + [i]
#         for i, val in enumerate(t):
#             d2[val] = d2.get(val, []) + [i]
#         return sorted(d1.values()) == sorted(d2.values())
#         
#     def isIsomorphic2(self, s, t):
#         d1, d2 = [[] for _ in xrange(256)], [[] for _ in xrange(256)]
#         for i, val in enumerate(s):
#             d1[ord(val)].append(i)
#         for i, val in enumerate(t):
#             d2[ord(val)].append(i)
#         return sorted(d1) == sorted(d2)
#         
#     def isIsomorphic3(self, s, t):
#         return len(set(zip(s, t))) == len(set(s)) == len(set(t))
#         
#     def isIsomorphic4(self, s, t): 
#         return [s.find(i) for i in s] == [t.find(j) for j in t]
#         
#     def isIsomorphic5(self, s, t):
#         return map(s.find, s) == map(t.find, t)
#     
#     def isIsomorphic(self, s, t):
#         d1, d2 = [0 for _ in xrange(256)], [0 for _ in xrange(256)]
#         for i in xrange(len(s)):
#             if d1[ord(s[i])] != d2[ord(t[i])]:
#                 return False
#             d1[ord(s[i])] = i+1
#             d2[ord(t[i])] = i+1
#         return True
# =============================================================================
print(Solution().isIsomorphic("egg","adh"))
