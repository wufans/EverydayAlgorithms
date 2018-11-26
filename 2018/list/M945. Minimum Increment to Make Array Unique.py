# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.



Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
"""


class Solution(object):
    def minIncrementForUnique(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        N = len(A)
        if N == 0: return 0
        A.sort()
        res = 0
        prev = A[0]
        for i in range(1, N):
            if A[i] <= prev:
                prev += 1
                res += prev - A[i]
            else:
                prev = A[i]
        return res
