# -*- coding: utf-8 -*-
"""
Created on Fri Aug 24 10:36:42 2018

@author: wufan

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
"""

class Solution:
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return "1"
        else:
            x = Solution().countAndSay(n-1)
            #x = list(string)
            tmp = x[0]
            #print(tmp)
            count = 0
            result = ""
            for i,num in enumerate(x):
                if num == tmp:
                    count += 1
                    if i == len(x) -1:
                        result += str(count)
                        result += str(num)
                else:
                    result += str(count)
                    result+= str(tmp)
                    
                    tmp = num
                    count = 1
                    if i == len(x) -1:
                        result += str("1")
                        result += str(num)
            return result
#        func = lambda x:return 
        #start = [1]
#        
#        if n == 1:
#            return Solution.test([1])
#        else:
#            return Solution.test(Solution.countAndSay(n-1))
#    def test(x):
##        x = list[x]
#        
#        tmp = x[0]
#        print(tmp)
#        count = 0
#        result = []
#        for i,num in enumerate(x):
#            if num == tmp:
#                count += 1
#                if i == len(x) -1:
#                    result.append(count)
#                    result.append(tmp)
#            else:
#                result.append(count)
#                result.append(tmp)
#                tmp = num
#                count = 1
#        return result
#    
#        
#        return test
for n in range(1,6):
    print(Solution().countAndSay(n))
