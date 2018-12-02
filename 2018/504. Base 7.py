# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
"""


class Solution(object):
    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0: return '0'
        n, res = abs(num), ''
        while n:
            res = str(n % 7) + res
            n //= 7
        return res if num > 0 else '-' + res
        #return int(num,7)
        # if num == 0:
        #     return "0"
        # if num < -10 ** 7 or num > 10 ** 7:
        #     return ""
        # cur = abs(num)
        # ret = []
        # while cur != 0:
        #     ret.append(cur % 7)
        #     cur /= 7
        # ret = ret[::-1]
        # # print ret
        # ret = "".join(map(str, ret))
        # return '-' + ret if num < 0 else ret
print(Solution().convertToBase7(100))
