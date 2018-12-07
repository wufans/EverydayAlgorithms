# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:







Return its preorder traversal as: [1,3,5,6,2,4].
"""

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution(object):
    #node = []
    def preorder(self, root,ans =None):
        """
        :type root: Node
        :rtype: List[int]
        """
    #     if not root:
    #         return []
    #     res = []
    #     self.helper(root,res)
    #     return res
    #
    # def helper(self,node,res):
    #     res.append(node.val)
    #     if node.children:
    #         for x in node.children:
    #             self.helper(x,res)
    #     ans = ans or list()
    #     if not root:
    #         return []
    #     ans.append(root.val)
    #     for child in root.children:
    #         self.preorder(child, ans)
    #     return ans

        traversal = [root]
        order = []
        current = root

        while traversal != [] and current != None:
            current = traversal.pop(0)
            order.append(current.val)
            traversal = current.children + traversal
        return order
