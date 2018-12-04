# -*- coding: utf-8 -*-
#@author: WuFan
"""
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)
"""


class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """

        #time exceed
        # tmp_list = [1]
        # tmp = 2
        # while tmp <= num//2:
        #     if num%tmp == 0:
        #         tmp_list.append(tmp)
        #
        #     tmp += 1
        # return sum(tmp_list) == num

        #time exceed
        # tmp_list = [1]
        # max_tmp = num//2
        # tmp =2
        # while tmp < max_tmp:
        #     if  num % tmp==0:
        #         max_tmp = num // tmp
        #         tmp_list.extend([tmp,max_tmp])
        #     tmp += 1
        # return sum(tmp_list) == num

        # if num <= 1:
        #     return False
        # sum = cur = 1
        # while cur < int(num ** 0.5):
        #     cur += 1
        #     if (num % cur == 0):
        #         sum += cur + num / cur
        # return sum == num

        #用开方处理
        import math
        if num <= 1:
            return False
        sum_ = 1
        j = int(math.sqrt(num)) + 1
        i = 2
        while i < j:
            if num % i == 0:
                sum_ += i
                k = num // i
                sum_ += k
                if sum_ > num:
                    return False
            i += 1
        return sum_ == num


print(Solution().checkPerfectNumber(1))
