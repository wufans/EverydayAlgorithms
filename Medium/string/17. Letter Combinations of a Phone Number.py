# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
"""


class Solution:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """

        #beats 33
        # string_map = ["abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        # res = []
        # for cha in digits:
        #     res.append(string_map[int(cha)-2])
        # result = [x for x in res[0]]
        # for chars in res[1:]:
        #     res_tmp = []
        #     for cha in chars:
        #         for x in result:
        #             res_tmp.append(x+cha)
        #     result = res_tmp
        # return result
        #
        if not digits:
            return []

        dic = {}
        dic[2] = ['a', 'b', 'c']
        dic[3] = ['d', 'e', 'f']
        dic[4] = ['g', 'h', 'i']
        dic[5] = ['j', 'k', 'l']
        dic[6] = ['m', 'n', 'o']
        dic[7] = ['p', 'q', 'r', 's']
        dic[8] = ['t', 'u', 'v']
        dic[9] = ['w', 'x', 'y', 'z']

        return self.getCombinations(digits, dic)

    def getCombinations(self, digits, dic):
        if len(digits) == 1:
            return dic[int(digits)]

        combinations = self.getCombinations(digits[1:], dic)
        letters = dic[int(digits[0])]
        results = []

        for l in letters:
            r = [l + c for c in combinations]
            results += r

        return results

print(Solution().letterCombinations("23"))

