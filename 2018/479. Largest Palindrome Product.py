# -*- coding: utf-8 -*-
#@author: WuFan
"""
Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.

Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

Note:

The range of n is [1,8].
"""


class Solution(object):
    def largestPalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        # return [9, 987, 123, 597, 677, 1218, 877, 475][n - 1]
        # return [9, 9009, 906609, 99000099, 9966006699, 999000000999, 99956644665999, 9999000000009999][n - 1] % 1337
        if n == 1: return 9
        left, right, power_n = 0, 0, 1
        for i in range(n):
            power_n *= 10
        for z in range(2, power_n):
            left = power_n - z
            right, temp = 0, left
            while temp:
                right = right * 10 + temp % 10
                temp /= 10
            root_1, root_2 = 0.0, 0.0
            mean_v = z ** 2 - 4 * right
            if mean_v < 0: continue
            mean_v = mean_v ** 0.5
            root_1 = (float(z) + mean_v) / 2
            root_2 = (float(z) - mean_v) / 2
            if (root_1 > 0 and root_1 == int(root_1)) or \
                    (root_2 > 0 and root_2 == int(root_2)):
                return (left * power_n + right) % 1337
print(Solution().largestPalindrome(3))
