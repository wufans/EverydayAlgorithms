# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
"""
class Solution:
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        """
        Consider the valid numbers within 32 bit, and turn them into binary form, they are:

1
100
10000
1000000
100000000
10000000000
1000000000000
100000000000000
10000000000000000
1000000000000000000
100000000000000000000
10000000000000000000000
1000000000000000000000000
100000000000000000000000000
10000000000000000000000000000
1000000000000000000000000000000
Any other number not it the list should be considered as invalid.
So if you XOR them altogether, you will get a mask value, which is:

1010101010101010101010101010101 (1431655765)
Any number which is power of 4, it should be power of 2, I use num &(num-1) == 0 to make sure of that.
Obviously 0 is not power of 4, I have to check it.
and finally I need to check that if the number 'AND' the mask value is itself, to make sure it's in the list above.

here comes the final code:

return num != 0 and num &(num-1) == 0 and num & 1431655765== num
        """
        return num != 0 and num & (num - 1) == 0 and num & 1431655765 == num

        # if (num <= 0):
        #     return False
        # a = math.log(num, 4)
        #这里需要判断a是否是
        # return True if int(a) == a else False
        # return True if math.floor(math.log(num,4)) == math.log(num,4) else False
