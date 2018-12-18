# -*- coding: utf-8 -*-
#@author: WuFan
"""
Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
Note:

s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.
"""


class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        # groups = [1]
        # for i in range(1, len(s)):
        #     if s[i - 1] != s[i]:
        #         groups.append(1)
        #     else:
        #         groups[-1] += 1
        #
        # ans = 0
        # for i in range(1, len(groups)):
        #     ans += min(groups[i - 1], groups[i])
        # return ans

        if len(s) == 1: return 0

        count = -1
        rec1 = 0
        rec2 = 0
        prev_digit = None
        for digit in s:
            if prev_digit == digit:
                rec1 += 1
                if rec2 >= rec1:
                    count += 1
            else:
                rec2 = rec1
                rec1 = 1
                count += 1
            prev_digit = digit
        return count
