# -*- coding: utf-8 -*-
"""
Created on Sat Sep 15 21:56:22 2018

@author: wufan
# =============================================================================
# Implement the following operations of a stack using queues.
# 
# push(x) -- Push element x onto stack.
# pop() -- Removes the element on top of the stack.
# top() -- Get the top element.
# empty() -- Return whether the stack is empty.
# Example:
# 
# MyStack stack = new MyStack();
# 
# stack.push(1);
# stack.push(2);  
# stack.top();   // returns 2
# stack.pop();   // returns 2
# stack.empty(); // returns false
# =============================================================================
"""
class MyStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        from collections import deque
        self.mystack = deque()

    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: void
        """
        self.mystack.appendleft(x)
        

    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        if len(self.mystack) == 0:
            return None
        else:
            return self.mystack.popleft()

    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        if len(self.mystack) == 0:
            return None
        else:
            return self.mystack[0]

    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        if len(self.mystack) == 0:
            return True
        else:
            return False
# =============================================================================
#     def __init__(self):
#         """
#         Constructor Initialize your data structure here.
#         """
#         self._queue = collections.deque()
# 
#     def push(self, item):
#         q = self._queue
#         q.append(item)
# 
#     def pop(self):
#         return self._queue.pop()
# 
#     def top(self):
#         return self._queue[-1]
# 
#     def empty(self):
#         """
#         Returns whether the stack is empty.
#         :rtype: bool
#         """
#         return len(self._queue) == 0 
# =============================================================================


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()

