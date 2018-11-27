# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"
"""


class Solution(object):
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        # return ''.join(
        #     '0123456789abcdef'[(num >> 4 * i) & 15]
        #     for i in range(8)
        # )[::-1].lstrip('0') or '0'

        if num == 0:
            return '0'
        s = ""
        ret = ""
        for i in range(31, -1, -1):
            if num & (1 << i):
                s = s + '1'
            else:
                s = s + '0'
        # print(s)
        for i in range(0, 32, 4):
            v = int(s[i:i + 4], 2)
            # print(s[i:i+4],v)
            if v == 0 and len(ret) == 0:
                continue
            if v <= 9:
                ret = ret + str(v)
            else:
                ret = ret + chr(v - 10 + ord('a'))
        return ret
