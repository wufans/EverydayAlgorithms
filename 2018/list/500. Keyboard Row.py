# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]


Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
"""


class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        # line1 = "eiopqrtuwy"
        # line2 = "adfghjkls"
        # line3 = "bcmnvxz"
        # res = []
        # for x in words:
        #     #print(x)
        #     #x = x.lower()
        #     if len(set(line1+x.lower())) == len(line1) or len(set(line2+x.lower())) == len(line2) or len(set(line3+x.lower())) == len(line3):
        #         res.append(x)
        # return res
#fastest solution
        def one_row(s):
            rows = [
                set(sorted('qwertyuiopQWERTYUIOP')),
                set(sorted('asdfghjklASDFGHJKL')),
                set(sorted('zxcvbnmZXCVBNM')),
            ]
            row_set = set()
            for c in s:
                for i in range(3):
                    if c in rows[i]:
                        row_set.add(i)
            return len(row_set) == 1

        ans = []
        for s in words:
            if one_row(s):
                ans.append(s)
        return ans


print(Solution().findWords(["Hello", "Alaska", "Dad", "Peace"]))
