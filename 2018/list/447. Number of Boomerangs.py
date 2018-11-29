# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
"""


class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
    # wrong answer
    #     if not points:
    #         return 0
    #     dis = []
    #
    #     for i in range(len(points)-1):
    #         for j in range(i+1,len(points)):
    #             dis.append(self.distance(points[i],points[j]))
    #             print(points[i],points[j])
    #     print(dis)
    #     return 2*(len(dis)-len(set(dis)))

    # time exceed
    #     if not points:
    #         return 0
    #     res = 0
    #     for i in range(len(points)-2):
    #         for j in range(i+1,len(points)-1):
    #             for z in range(j+1,len(points)):
    #                 dis_tmp = [self.distance(points[i],points[j]),self.distance(points[i],points[z]),self.distance(points[z],points[j])]
    #                 if len(set(dis_tmp)) == 1:
    #                     res = res + 3
    #                 elif len(set(dis_tmp)) == 2:
    #                     res = res + 2
    #                 else:
    #                     continue
    #     return res
    # def distance(self,vec1, vec2):
    #     res_dis = 0
    #     for index in range(len(vec1)):
    #         res_dis = res_dis + (vec1[index] - vec2[index]) ** 2
    #     return res_dis

        # res = 0
        # for p in points:
        #     cmap = {}
        #     for q in points:
        #         f = p[0] - q[0]
        #         s = p[1] - q[1]
        #         cmap[f * f + s * s] = 1 + cmap.get(f * f + s * s, 0)
        #     for k in cmap:
        #         res += cmap[k] * (cmap[k] - 1)
        # return res

        # result = 0
        #
        # for x, y in points:
        #     print(x,y)
        #     dist_dict = {}
        #     for i, j in points:
        #         distance = (x - i) * (x - i) + (y - j) * (y - j)
        #         print(dist_dict,i,j)
        #         if distance in dist_dict:
        #             result += dist_dict[distance]
        #             dist_dict[distance] += 1
        #         else:
        #             dist_dict[distance] = 1
        #     print("sdfa",result)
        #
        # return result * 2
        result = 0

        for x, y in points:
            dist_dict = {}
            for i, j in points:
                distance = (x - i) * (x - i) + (y - j) * (y - j)
                if distance in dist_dict:
                    result += dist_dict[distance]
                    dist_dict[distance] += 1
                else:
                    dist_dict[distance] = 1

        return result * 2



#print(Solution().numberOfBoomerangs([[0,0],[1,0],[-1,0],[0,1],[0,-1]]))
print(Solution().numberOfBoomerangs([[0,0],[1,0],[2,0]]))
