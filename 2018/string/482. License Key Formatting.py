# -*- coding: utf-8 -*-
#@author: WuFan
"""
You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:
Input: S = "2-5g-3-J", K = 2

Output: "2-5G-3J"

Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
Note:
The length of string S will not exceed 12,000, and K is a positive integer.
String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
String S is non-empty.
"""


class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        #time exceed
        # if not S or not K:
        #     return  ""
        # S = S.replace("-","").upper()
        # res = ""
        # count = 1
        # for x in S[::-1]:
        #     if count == K:
        #         count = 1
        #         res = res + x +"-"
        #     else:
        #         res += x
        #         count += 1
        # return res[::-1].strip("-")


        #time exceed
        # res = ""
        # count = 1
        # for x in S.upper()[::-1]:
        #     #print(x)
        #     if x != "-":
        #         if count == K:
        #             count = 1
        #             res = res + x + "-"
        #         else:
        #             res += x
        #             count += 1
        #     #print(res)
        # if res[-1] == "-":
        #     return res[-2::-1]#[::-1]
        # else:
        #     return res[::-1]

        #time exceed
        # res = ""
        # count = 1
        # for x in S[::-1]:
        #     #print(x)
        #     if x != "-":
        #         if count == K:
        #             count = 1
        #             res = res + x.upper() + "-"
        #         else:
        #             res += x.upper()
        #             count += 1
        #     #print(res)
        # if res[-1] == "-":
        #     return res[-2::-1]#[::-1]
        # else:
        #     return res[::-1]


        #
        # S = S.upper().replace('-', '')
        # size = len(S)
        # s1 = K if size % K == 0 else size % K
        # res = S[:s1]
        # while s1 < size:
        #     res += '-' + S[s1:s1 + K]
        #     s1 += K
        # return res

        #fastest
        S = S.replace('-', '').upper()
        res = []
        if len(S) > 0:
            first = K if len(S) % K == 0 else len(S) % K
            res.append(S[:first])
            for i in range(first, len(S), K):
                res.append(S[i:i + K])
            return ('-'.join(res))
        else:
            return ''


print(Solution().licenseKeyFormatting("5F3Z-2e-9-w", K = 4))
