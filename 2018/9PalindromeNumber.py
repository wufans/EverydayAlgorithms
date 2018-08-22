# -*- coding: utf-8 -*-
"""
Created on Mon Aug 20 20:43:36 2018

@author: wufan

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
"""
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        
#        if x >= 0:
#            return str(x)[::-1] == str(x)
#        else:
#            return False
        
#        可以只用下面一行代码
#        return str(x)[::-1] == str(x)
        
#        No string method
#        这个方法有问题，迭代过程如下：可以通过将小数减法变为整数减法降低误差。
#        x = (x-num)/10
#        x = x/10-num/10#错误
        
#        102411420.0
#        10241142.0
#        1024114.0
#        102411.0
#        10241.0
#        1023.9999999999999
#        102.0
#        10.0
#        1.0
#        0.0
        
        
        
#        
        nums = x
        if x >= 0:
            result_list = []
            while(x!=0):
               num = x%10
               x = (x-num)/10
               result_list.append(int(num))
               #print(x,num)
               #if x = 0: break
            result = 0
            for i,j in enumerate(result_list):
                result += int(j*pow(10,len(result_list)-i-1))
            print(result_list)
            print(result)
            if result == nums:
                
                return True
            else :return False
        else:
            return False
test = Solution()
print(test.isPalindrome(1024114201))
