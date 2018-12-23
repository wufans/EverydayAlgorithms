# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
"""



class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        """
        思路1：
            暴力遍历，按照长度递减的顺序
        """
        # for length in range(len(s), 0, -1):
        #     for start in range(len(s)-length+1):
        #         if s[start:start+length] == s[start:start+length][::-1]:
        #             return s[start:start+length]
        # return ""
        """
        思路2：
         动态规划解法：
            dp数组：维护子串状态
            step 1:初始化dp数组,完成长度小于3的子串状态判断
            step 2:i为子串长度，j为子串起始地址，r为子串结束地址.
            第二步逐步得到长度为i的子串状态，利用状态转移方程完成这一判断。
            step 3:根据第二步得到的最长子串长度和起始位置，得到最终结果
        """

        # if not s:
        #     return None
        # lens = len(s)
        # if lens < 2:
        #     return s
        # maxlen = 0
        # start = 0
        # dp = [[0] * lens] * lens
        #
        # # step 1
        # for i in range(lens):
        #     dp[i][i] = True
        #     if i < lens - 1 and s[i] == s[i + 1]:
        #         dp[i][i + 1] = 1
        #         start = i
        #         maxlen = 2
        #
        # # step 2
        # for i in range(3, lens + 1):
        #     for j in range(0, lens - i + 1):
        #         r = j + i - 1
        #         if dp[j + 1][r - 1] and s[j] == s[r]:
        #             dp[j][r] = 1
        #             maxlen = i
        #             start = j
        # # step 3
        # if maxlen >= 2:
        #     return s[start:start + maxlen]
        # return None

        """
        思路3：
        中心扩展法
        step 1:遍历每个字符,把每个字符当做中心逐步向两边扩展,每扩展一步就得到一个新的子串。
        这里针对输入字符串的长度，扩展方式需要根据长度奇偶性质做判断。
        Step 2:判断子串是否为回文串，更新当前最长回文串
        Step 3:返回最长回文串
        """
        lens = len(s)
        maxlen = 0
        start = 0

        # 长度为奇数
        for i in range(lens):
            j = i - 1
            k = i + 1
            while j >= 0 and k < lens and s[j] == s[k]:
                if k - j + 1 > maxlen:
                    maxlen = k - j + 1
                    start = j
                j -= 1
                k += 1

        # 长度为偶数
        for i in range(lens):
            j = i
            k = i + 1
            while j >= 0 and k < lens and s[j] == s[k]:
                if k - j + 1 > maxlen:
                    maxlen = k - j + 1
                    start = j
                j -= 1
                k += 1

        if maxlen > 0:
            return s[start:start + maxlen]
        return None

        '''
        Manacher算法:
        step 1: 字符串内插入特殊字符'#'，处理后字符串长度为奇数；字符串收尾插入特殊字符，避免数组越界
        step 2:逐个遍历字符，计算得到以每个字符为中心的最长回文串半径。
        涉及到的变量有：存储字符i回文半径的数组P，上一个回文串的中心位置c以及回文串结束位置r。
        计算字符i回文半径：本次计算尽量利用之前回文串匹配的结果，减少重复字符比对。
        '''

        # T = '#'.join('^{}$'.format(s))
        # n = len(T)
        # P = [0] * n
        # C = R = 0
        # for i in range(1, n - 1):
        #     P[i] = (R > i) and min(R - i, P[2 * C - i])  # equals to i' = C - (i-C)
        #     # Attempt to expand palindrome centered at i
        #     while T[i + 1 + P[i]] == T[i - 1 - P[i]]:
        #         P[i] += 1
        #
        #     # If palindrome centered at i expand past R,
        #     # adjust center based on expanded palindrome.
        #     if i + P[i] > R:
        #         C, R = i, i + P[i]
        #
        # # Find the maximum element in P.
        # maxLen, centerIndex = max((n, i) for i, n in enumerate(P))
        # return s[(centerIndex - maxLen) // 2: (centerIndex + maxLen) // 2]


print(Solution().longestPalindrome(""))
