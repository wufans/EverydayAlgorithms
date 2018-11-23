# -*- coding: utf-8 -*-
#@author: WuFan
"""
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
"""


class Solution:
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        # vowels = "aeiouAEIOU"
        # s = list(s)
        # h = 0
        # t = len(s) - 1
        # while (t > h):
        #     if s[h] in vowels and s[t] in vowels:
        #         s[h], s[t] = s[t], s[h]
        #         h += 1
        #         t -= 1
        #     elif not s[h] in vowels:
        #         h += 1
        #     else:
        #         t -= 1
        # return "".join(s)
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        L = list(s)
        i = 0
        j = len(L) - 1
        while i < j:
            while i < j and L[i] not in vowels:
                i += 1
            while j > i and L[j] not in vowels:
                j -= 1
            L[i], L[j] = L[j], L[i]
            i += 1
            j -= 1
#最短的solution
        # def reverseVowels(self, s):
        #     vowels = re.findall('(?i)[aeiou]', s)
        #     return re.sub('(?i)[aeiou]', lambda m: vowels.pop(), s)
        return ''.join(L)


print(Solution().reverseVowels("leetcode"))
