# -*- coding: utf-8 -*-
#@author: WuFan
"""
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

"""


class Solution(object):
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """
        # beates 11%
        # k = 0
        # while (k * (k + 1)) / 2 < n:
        #     k = k + 1
        # return k - 1 if (k * (k + 1)) / 2 > n else k

        # tmp_n = 0
        # k = 0
        # while tmp_n < n:
        #     k = k + 1
        #     tmp_n = tmp_n + k
        # return k -1 if tmp_n > n else k
        import math
        return  int((math.sqrt(8 * n + 1)-1)/2)
