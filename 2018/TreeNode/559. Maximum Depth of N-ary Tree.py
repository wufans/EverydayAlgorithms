# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:






We should return its max depth, which is 3.



Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
"""
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Node
        :rtype: int
        """
        #46.12%
        # if not root:
        #     return 0
        # father = [root]
        # res = 0
        # while father:
        #     res += 1
        #     new_father = []
        #     for one_father in father:
        #         for one_children in one_father.children:
        #             new_father.append(one_children)
        #     father = new_father
        # return res
        if not root:
            return 0
        max_depth = 0
        queue = [root]

        while queue:
            new_queue = []
            max_depth += 1
            new_queue = [child for node in queue for child in node.children if child]
            queue = new_queue

        return max_depth
