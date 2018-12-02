# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2


return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findMode(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.max_cnt = 0
        dic = dict()

        def dfs(root):
            if not root:
                return
            dic.setdefault(root.val, 0)
            dic[root.val] += 1
            self.max_cnt = max(self.max_cnt, dic[root.val])
            dfs(root.left)
            dfs(root.right)

        dfs(root)
        res = []
        for k, v in dic.items():
            if v == self.max_cnt:
                res.append(k)
        return res
    #     if not root:
    #         return []
    #
    #     modes = []
    #     val, freq, max_freq, modes = self.dfs(root, None, 0, 0, modes)
    #     return modes
    #
    # def dfs(self, node, val, freq, max_freq, modes):
    #     if node.left:
    #         val, freq, max_freq, modes = self.dfs(node.left, val, freq, max_freq, modes)
    #
    #     if node.val == val:
    #         freq += 1
    #     else:
    #         freq = 1
    #         val = node.val
    #
    #     if freq > max_freq:
    #         modes = [val]
    #         max_freq = freq
    #     elif freq == max_freq:
    #         modes.append(val)
    #
    #     if node.right:
    #         val, freq, max_freq, modes = self.dfs(node.right, val, freq, max_freq, modes)
    #
    #     return val, freq, max_freq, modes

