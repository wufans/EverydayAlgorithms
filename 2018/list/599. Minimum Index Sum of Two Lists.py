# -*- coding: utf-8 -*-
#@author: WuFan
"""
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
"""
class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        # d = {l:i for i,l in enumerate(list1)}
        # sm = {l:i+d[l] for i,l in enumerate(list2) if l in d}
        # mn = min(v for v in sm.values())
        # return [k for k,v in sm.items() if v == mn]

        dic = {}

        for idx, restaurant in enumerate(list1):
            dic[restaurant] = idx

        ans = []
        min_sum = 1e13
        for idx, restaurant in enumerate(list2):
            if restaurant in dic:
                tmp_sum = dic[restaurant] + idx
                if tmp_sum < min_sum:
                    ans = []
                    min_sum = tmp_sum
                    ans.append(restaurant)
                elif tmp_sum == min_sum:
                    ans.append(restaurant)

        return ans
