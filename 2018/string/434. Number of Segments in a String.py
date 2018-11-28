# -*- coding: utf-8 -*-
#@author: WuFan
"""
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
"""


class Solution(object):
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        # return sum(s[i] != ' ' and (i == 0 or s[i-1] == ' ') for i in range(len(s)))

        # if s == '' or set(s) == {' '}:
        #     return 0
        #
        # res = s.split(" ")
        # print(res)
        # # print res
        # ans = 0
        # for r in res:
        #     if r != '':
        #         ans += 1
        # return ans

        # if len(s.strip()) == 0:
        #     return 0
        # my one-line solution
        return len([x for x in s.split(" ") if x != ""]) if len(s.strip()) != 0 else 0


print(Solution().countSegments("Hello, my name is John"))
