# -*- coding: utf-8 -*-
"""
Created on Thu Sep  6 16:52:27 2018

@author: wufan
# =============================================================================
# Reverse bits of a given 32 bits unsigned integer.
# 
# Example:
# 
# Input: 43261596
# Output: 964176192
# Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
#              return 964176192 represented in binary as 00111001011110000010100101000000.
# Follow up:
# If this function is called many times, how would you optimize it?
# =============================================================================
"""

class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        x = list(str(bin(n)).replace("0b",""))
        while len(x) < 32:
            x.insert(0,"0")
        x[:]=x[::-1]
        return int("".join(x),2)
    
        #solution1
        # s = bin(n)[2:]
        # zs = '0' * (32 - len(s)) if len(s) < 32 else ''
        # return int('0b' + (zs + s)[::-1], 2)
        
        #solution2
        #s = '{:0>32b}'.format(n)
        #return int(s[::-1], 2)
print(Solution().reverseBits(43261596))
