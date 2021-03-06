# -*- coding: utf-8 -*-
# @Time    : 2018/12/20 23:35
# @Author  : wufan
# @Email   : wufan123321@gmail.com

"""
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
"""
class KthLargest(object):

    # def __init__(self, k, nums):
    #     """
    #     :type k: int
    #     :type nums: List[int]
    #     """
    #     #挺有意思 想要边插入边排序的话 用优先队列 采取的是堆排序的方式
    #     #找到第k大的数字的话 也就是说比第k大数字小的那些数字都可以舍去
    #     #不需要保留那些数字的内存
    #     self.pool = nums
    #     self.size = len(self.pool)
    #     self.k = k
    #     heapq.heapify(self.pool)
    #     while self.size >k:
    #         heapq.heappop(self.pool)
    #         self.size -= 1
    #
    # def add(self, val):
    #     """
    #     :type val: int
    #     :rtype: int
    #     """
    #     if self.size < self.k:
    #         heapq.heappush(self.pool,val)
    #         self.size += 1
    #     elif val>self.pool[0]:
    #         heapq.heapreplace(self.pool,val)
    #     return self.pool[0]
    import heapq
    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        self.nums = nums
        self.k = k
        heapq.heapify(self.nums)
        while len(self.nums) > k:
            heapq.heappop(self.nums)

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        if len(self.nums) < self.k:
            heapq.heappush(self.nums, val)
        elif val > self.nums[0]:
            heapq.heapreplace(self.nums, val)
        return self.nums[0]

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
