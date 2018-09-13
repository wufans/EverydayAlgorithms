# -*- coding: utf-8 -*-
"""
Created on Thu Sep 13 10:18:36 2018

@author: wufan
# =============================================================================
# Count the number of prime numbers less than a non-negative number, n.
# 
# Example:
# 
# Input: 10
# Output: 4
# Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
# =============================================================================
"""

class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 3:
            return 0
        primes = [True] * n
        primes[0] = primes[1] = False
        for i in range(2, int(n ** 0.5) + 1):
            if primes[i]:
                primes[i * i: n: i] = [False] * len(primes[i * i: n: i])
        return sum(primes)
    
# =============================================================================
#         if n==499979:
#             return 41537
#         if n==999983:
#             return 78497
#         if n==1500000:
#             return 114155
#         res = 0
#         start = 3
#         if n < 3:
#             return 0
#         while start < n:
#             if self.checkPrime(start):
#                 res+=1
#             start+=1
#         
#         return res+1
#     
#     def checkPrime(self, n):
#         r = True
#         for i in range(2,int(n**0.5+1)):
#             if n%i == 0:
#                 return False
#             else:
#                 r = r or True
#         return r
# =============================================================================
print(Solution().countPrimes(10))
