# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.
"""


class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """

        # s = bin(n)
        # return '00' not in s and '11' not in s

        # b = list(bin(n)[2:])
        # for i in range(1, len(b)):
        #     if b[i - 1] == b[i]:
        #         return False
        # return True

        if not n:
            return False
        num = n ^ (n >> 1)
        return not (num & (num + 1))

print(Solution().hasAlternatingBits(4))
