/**
 * @Author: WuFan
 * @Date: 2019/1/20 14:50
 */

package leetcode;
/*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]*/
//用二分法查找
public class Solution34 {
    public int left = -1, right = -1;

    public int[] searchRange(int[] nums, int target) {
        helper(nums, target, 0, nums.length);
        return new int[]{left, right};
    }

    public void helper(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                if (left == -1) {
                    left = right = mid;
                } else {
                    if (mid < left) left = mid;
                    if (mid > right) right = mid;
                }
                helper(nums, target, l, mid);
                helper(nums, target, mid + 1, r);
                break;
            }
        }
    }
}
