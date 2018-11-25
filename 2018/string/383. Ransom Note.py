# -*- coding: utf-8 -*-
#@author: WuFan

"""
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
"""


class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        #return all(ransomNote.count(c) <= magazine.count(c) for c in ransomNote)
        l = {}
        m = len(ransomNote)
        if m == 0:
            return True
        if m > len(magazine):
            return False
        for i in ransomNote:
            if i in l:
                c = magazine.find(i, l[i] + 1)
                if c == -1:
                    return False
                l[i] = c
            else:
                c = magazine.find(i)
                if c == -1:
                    return False
                l[i] = c
        return True
