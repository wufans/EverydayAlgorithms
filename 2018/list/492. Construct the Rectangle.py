# -*- coding: utf-8 -*-
#@author: WuFan

"""
For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

1. The area of the rectangular web page you designed must equal to the given target area.

2. The width W should not be larger than the length L, which means L >= W.

3. The difference between length L and width W should be as small as possible.
You need to output the length L and the width W of the web page you designed in sequence.
Example:
Input: 4
Output: [2, 2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
Note:
The given area won't exceed 10,000,000 and is a positive integer
The web page's width and length you designed must be positive integers.
"""


class Solution(object):
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        #time exceed
        # length = round(area ** 0.5)
        # while (area % length != 0):
        #     length += 1
        # return sorted([int(length), int(area / length)])[::-1]

        #20%
        # if area <= 3:
        #     return [area,1]
        #
        # start = 1
        # end = area
        # tmp = (start + end)//2
        # while(tmp**2 != area):
        #     if tmp**2 < area:
        #         start = tmp
        #     elif tmp**2>area:
        #         end = tmp
        #     tmp = (start + end)//2
        #     if end == start + 1:
        #         tmp = tmp +1
        #         break
        #
        # length = tmp
        # print(length)
        # while(area%length != 0):
        #     length += 1
        # return [int(length),int(area/length)]
        import math
        maxW = int(math.sqrt(area))
        for W in range(maxW, 0, -1):
            if area % W == 0:
                L = area / W
                if W <= L:
                    return [L, W]
        return []

print(Solution().constructRectangle(90991))
