# -*- coding: utf-8 -*-
#@author: WuFan

"""
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
"""

class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """

        def is_square(N):
            return int(N ** .5) ** 2 == N

        return any(is_square(c - a * a)
                   for a in range(int(c ** .5) + 1))

        # if c < 3:
        #     return True
        # while c % 2 == 0:
        #     c = c // 2
        # if c % 4 == 3:
        #     return False
        # i = 3
        # while i <= c ** 0.5:
        #     j = 0
        #     while c % i == 0:
        #         j += 1
        #         c = c // i
        #     if i % 4 == 3 and j % 2 == 1:
        #         return False
        #     i += 2
        # return c % 4 == 1
