# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
"""


class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """

        #beats 25
        # number = ["0","1","2","3","4","5","6","7","8","9"]
        # num_1 = 0
        # num_2 = 0
        # count = 1
        # for i in num1[::-1]:
        #     num_1 = num_1 + number.index(i)*count
        #     count = count*10
        # count = 1
        # for i in num2[::-1]:
        #     num_2 = num_2 + number.index(i) * count
        #     count = count * 10
        # return str(num_1+num_2)

        num1, num2 = list(num1), list(num2)
        carry, res = 0, []
        while len(num2) > 0 or len(num1) > 0:
            n1 = ord(num1.pop()) - ord('0') if len(num1) > 0 else 0
            n2 = ord(num2.pop()) - ord('0') if len(num2) > 0 else 0

            temp = n1 + n2 + carry
            res.append(temp % 10)
            carry = temp // 10
        if carry: res.append(carry)
        return ''.join([str(i) for i in res])[::-1]

print(Solution().addStrings("456","111"))
