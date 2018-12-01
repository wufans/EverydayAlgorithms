# -*- coding: utf-8 -*-
#@author: WuFan
"""
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
"""


class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        # my one-line solution but time exceed!!!
        #return max([min([abs(i-j) for j in heaters]) for i in houses for j in houses]) if houses and heaters else 0
        houses.sort()
        heaters.sort()

        v = []
        p = 0
        for h in houses:
            if h == heaters[p]:
                v.append(0)
            if h < heaters[p]:
                if p != 0:
                    v.append(min(h - heaters[p - 1], heaters[p] - h))
                else:
                    v.append(heaters[p] - h)
            if h > heaters[p]:
                while p < len(heaters) - 1:
                    p += 1
                    if heaters[p] >= h:
                        break
                if h == heaters[p]:
                    v.append(0)
                elif h < heaters[p]:
                    v.append(min(h - heaters[p - 1], heaters[p] - h))
                elif h > heaters[p]:
                    v.append(h - heaters[p])

        return max(v)
        # heaters = sorted(heaters) + [float('inf')]
        # i = r = 0
        # for x in sorted(houses):
        #     while x >= sum(heaters[i:i + 2]) / 2.:
        #         i += 1
        #     r = max(r, abs(heaters[i] - x))
        # return r
print(Solution().findRadius([1,2,3,4],[1,4]))
#print(Solution().findRadius([],[]))
