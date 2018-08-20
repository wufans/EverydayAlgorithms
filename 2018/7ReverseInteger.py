# -*- coding: utf-8 -*-
"""
Created on Sun Aug 19 21:47:20 2018

@author: wufan

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
"""

class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
#        maxn = pow(2,31)-1
#        minn = -pow(2,31)
#        if x > maxn or x < minn:
#            return 0
#        num = []
#        while(True):
#            num_tmp = x%10
#            num.append(num_tmp)
#            x = x/10 - num_tmp/10
#            if x == 0 :
#                break
#        result = 0
#        lenth = len(num)
#        for i,num_s in enumerate(num):
#            result += num_s*pow(10,lenth -1 - i)
#        if result > maxn or result < minn:
#            return 0
#        return int(result)
        
        
        
        
        flag = 1 if x >= 0 else -1
        new_x, x = 0, abs(x)
        while x:
            new_x = 10 * new_x + x % 10
            x /= 10
        new_x = flag * new_x
        return new_x if new_x < 2147483648 and new_x >= -2147483648 else 0
#        字符串的方式
#        x = int(str(x)[::-1]) if x >= 0 else - int(str(-x)[::-1])
#        return x if x < 2147483648 and x >= -2147483648 else 0
        
test = Solution()
print(test.reverse(-11120))