# -*- coding: utf-8 -*-
"""
Created on Sun Sep  2 20:49:11 2018

@author: wufan
# =============================================================================
# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
# 
# push(x) -- Push element x onto stack.
# pop() -- Removes the element on top of the stack.
# top() -- Get the top element.
# getMin() -- Retrieve the minimum element in the stack.
# Example:
# MinStack minStack = new MinStack();
# minStack.push(-2);
# minStack.push(0);
# minStack.push(-3);
# minStack.getMin();   --> Returns -3.
# minStack.pop();
# minStack.top();      --> Returns 0.
# minStack.getMin();   --> Returns -2.
# =============================================================================

"""
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack_list = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
#        if self.stack_list == []:
#            return None
        self.stack_list.append(x)

    def pop(self):
        """
        :rtype: void
        """
        if self.stack_list == []:
            return None
        else:
            return self.stack_list.pop()

    def top(self):
        """
        :rtype: int
        """
        if self.stack_list == []:
            return None
        else:
            return self.stack_list[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.stack_list == []:
            return None
        else:
            return min(self.stack_list)


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(5)
obj.push(9)
#obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_3,param_4)
