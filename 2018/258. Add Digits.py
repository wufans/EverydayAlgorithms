# -*- coding: utf-8 -*-
#@author: WuFan

# Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
#
# Example:
#
# Input: 38
# Output: 2
# Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
#              Since 2 has only one digit, return it.

class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num >= 10:
            tmp = 0
            for x in list(str(num)):
                tmp += int(x)
            print(tmp)
            num = tmp
        return num

        # while (num >= 10):
        #     temp = 0
        #     while (num > 0):
        #         temp += num % 10
        #         num /= 10
        #     num = temp
        # return num
print(Solution().addDigits(38))
