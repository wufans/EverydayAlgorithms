# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:







We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]


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
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        # node = [root]
        # #print(type(node[0]))
        # result = []
        # while len(node)!=0:
        #     result.append([x.val for x in node if x.val])
        #     node = [c.children for c in node if c.children]
        # return result
        if not root:
            return []
        node = [root]
        result = []
        while node:
            result.append([x.val for x in node if x.val != None])
            #如果是if x.value,x的值也不能为0！！！！！！！
            node_tmp = []
            for x in node:
                if isinstance(x.children, list):
                    for y in x.children:
                        node_tmp.append(y)
                elif x.children != None:
                    node_tmp.append(x.children)
            node = node_tmp
        return result
###fastest solution
        # result, level = [], [root]
        # while root and level:
        #     result += [node.val for node in level],
        #     level = [child for node in level for child in node.children if child]
        # return result
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children


a = Node(1,None)
d = Node(4,None)
b= Node(2,[a,d])
c=Node(3,b)
print(Solution().levelOrder(c))
#print(isinstance(b.children, list))
