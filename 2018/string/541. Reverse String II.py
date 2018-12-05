# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
"""


class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        # My %100
        # if not s:
        #     return s
        # res = ""
        # tmp = 0
        # while(tmp+2*k <=len(s)):
        #     #print(s[tmp:tmp+k][::-1])
        #     res = res + s[tmp:tmp+k][::-1]+s[tmp+k : tmp+2*k]
        #     #print(res)
        #     tmp += 2*k
        # if  len(s)-tmp < k:
        #     res += s[tmp:][::-1]
        # else:
        #     res += s[tmp:tmp+k][::-1]+s[tmp+k:]
        # return res

        slen = len(s)
        result = ''

        limit = (slen // (2 * k)) * 2 * k

        remain = slen % (2 * k)

        i = 0
        while i < limit:
            try:
                result += s[i:i + k][::-1] + s[i + k:i + 2 * k]
            except:
                pass
            i += 2 * k

        return result + s[limit:limit + k][::-1] + s[limit + k:]
print( Solution().reverseStr("abcdefgh", k = 3))
