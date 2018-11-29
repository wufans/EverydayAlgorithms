# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
"""
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        # time exceeded

        # lenth = len(p)
        # res = []
        # if lenth == 1:
        #     for index,x in enumerate(list(s)):
        #         if x == p:
        #             res.append(index)
        # else:
        #     for index, x in enumerate(list(s[:-lenth+1])):
        #         if sorted(s[index:index+lenth]) == sorted(p):
        #             res.append(index)
        # return res
#滑动窗口的思想
        len_p, len_s = len(p), len(s)

        m = collections.defaultdict(int)
        for i in range(len_p):
            m[p[i]] += 1

        ret = []
        start, end = 0, 0
        count = len_p
        while end < len_s and start < len_s:
            while end < len_s and s[end] in m and m[s[end]] > 0:
                m[s[end]] -= 1
                end += 1
                count -= 1

            if count == 0:
                ret.append(start)

                while end < len_s and s[end] == s[start]:
                    start += 1
                    end += 1
                    ret.append(start)

            if end == len_s:
                break

            if s[end] not in m:
                while start < end:
                    m[s[start]] += 1
                    start += 1
                start = end + 1
                end = end + 1
                count = len_p
                continue

            while s[start] != s[end]:
                m[s[start]] += 1
                start += 1
                count += 1

            start += 1
            end += 1

        return ret

print(Solution().findAnagrams("aaaa",""))
