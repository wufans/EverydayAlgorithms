# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree:







Return its postorder traversal as: [5,6,3,2,4,1].


Note:

Recursive solution is trivial, could you do it iteratively?
"""
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution(object):
    def postorder(self, root,ans =None):
        """
        :type root: Node
        :rtype: List[int]
        """
        # if root is None:
        #     return []
        #
        # stack, output = [root, ], []
        # while stack:
        #     root = stack.pop()
        #     if root is not None:
        #         output.append(root.val)
        #     for c in root.children:
        #         stack.append(c)
        #
        # return output[::-1]

        if ans is None:
            ans = list()

        if not root:
            return []
        for child in root.children:
            self.postorder(child, ans)
        ans.append(root.val)
        return ans
