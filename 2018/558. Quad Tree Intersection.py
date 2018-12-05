# -*- coding: utf-8 -*-
#@author: WuFan
"""
A quadtree is a tree data in which each internal node has exactly four children: topLeft, topRight, bottomLeft and bottomRight. Quad trees are often used to partition a two-dimensional space by recursively subdividing it into four quadrants or regions.

We want to store True/False information in our quad tree. The quad tree is used to represent a N * N boolean grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same. Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

For example, below are two quad trees A and B:

A:
+-------+-------+   T: true
|       |       |   F: false
|   T   |   T   |
|       |       |
+-------+-------+
|       |       |
|   F   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight: T
bottomLeft: F
bottomRight: F

B:
+-------+---+---+
|       | F | F |
|   T   +---+---+
|       | T | T |
+-------+---+---+
|       |       |
|   T   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight:
     topLeft: F
     topRight: F
     bottomLeft: T
     bottomRight: T
bottomLeft: T
bottomRight: F


Your task is to implement a function that will take two quadtrees and return a quadtree that represents the logical OR (or union) of the two trees.

A:                 B:                 C (A or B):
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       | F | F |  |       |       |
|   T   |   T   |  |   T   +---+---+  |   T   |   T   |
|       |       |  |       | T | T |  |       |       |
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       |       |  |       |       |
|   F   |   F   |  |   T   |   F   |  |   T   |   F   |
|       |       |  |       |       |  |       |       |
+-------+-------+  +-------+-------+  +-------+-------+
Note:

Both A and B represent grids of size N * N.
N is guaranteed to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.
The logic OR operation is defined as this: "A or B" is true if A is true, or if B is true, or if both A and B are true.
"""
"""
# Definition for a QuadTree node.
class Node(object):
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""


class Solution(object):
    def intersect(self, q1, q2):
        """
        :type quadTree1: Node
        :type quadTree2: Node
        :rtype: Node
        """
        # if q1.isLeaf:
        #     return q1.val and q1 or q2
        # elif q2.isLeaf:
        #     return q2.val and q2 or q1
        # else:
        #     tLeft = self.intersect(q1.topLeft, q2.topLeft)
        #     tRight = self.intersect(q1.topRight, q2.topRight)
        #     bLeft = self.intersect(q1.bottomLeft, q2.bottomLeft)
        #     bRight = self.intersect(q1.bottomRight, q2.bottomRight)
        #     if tLeft.isLeaf and tRight.isLeaf and bLeft.isLeaf and bRight.isLeaf and tLeft.val == tRight.val == bLeft.val == bRight.val:
        #         node = Node(tLeft.val, True, None, None, None, None)
        #     else:
        #         node = Node(False, False, tLeft, tRight, bLeft, bRight)
        # return node
        # if t1.isLeaf:
        #     return t1.val and t1 or t2
        # if t2.isLeaf:
        #     return t2.val and t2 or t1
        # t1.topLeft = self.intersect(t1.topLeft, t2.topLeft)
        # t1.topRight = self.intersect(t1.topRight, t2.topRight)
        # t1.bottomLeft = self.intersect(t1.bottomLeft, t2.bottomLeft)
        # t1.bottomRight = self.intersect(t1.bottomRight, t2.bottomRight)
        #
        # trees = (t1.topLeft, t1.topRight, t1.bottomLeft, t1.bottomRight)
        # if all(x.isLeaf for x in trees) and len(set(x.val for x in trees)) == 1:
        #     t1 = Node(t1.topLeft.val, True, None, None, None, None)
        # return t1
