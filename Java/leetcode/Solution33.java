/**
 * @Author: WuFan
 * @Date: 2019/1/17 14:38
 */

package leetcode;
/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1*/
public class Solution33 {
    public int search(int[] nums, int target) {
        //最简单的解法
//        for(int i = nums.length-1;i>=0;i--){
//            if(target == nums[i]){
//                return i;
//            }
//        }
//        return -1;

        //优化后的一个solution--好像更复杂了。。。
        //分别和最后一个数字以及第一个数字比较，如果比第一个数字小，再和最后一个数字比较，如果比最后一个数字大，则说明没有这个数字。

//        if(nums == null){
//            return -1;
//        }
//        if(nums[0]>target && nums[nums.length-1]<target){
//            return -1;
//        }
//        else if(nums[0]<=target){
//            if(nums[0]==target){
//                return 0;
//            }
//            for (int i = 1; i < nums.length; i++) {
//                if(nums[i] < nums[i-1]){
//                    return -1;}
//                if(nums[i]==target){
//                    return i;
//                }
//            }
//        }
//        else{
//            if(nums[nums.length-1]==target){
//                return nums.length-1;
//            }
//            for (int i = nums.length-2; i >= 0 ; i--) {
//                if(nums[i]>nums[i+1]){
//                    return -1;
//                }
//                if(nums[i]==target){
//                    return i;
//                }
//            }
//        }
//        return -1;


        //拓展二分方法
        if (nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length-1, mid, m;
        int first = nums[0];
        boolean left = target >= first;
        while (start < nums.length && end > -1 && start <= end) {
            mid = (start + end) / 2;
            m = nums[mid];
            if (m == target) {
                return mid;
            }
            if (m >= first) {
                if (m > target) {
                    if (left) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    start = mid + 1;
                }
            } else {
                if (m > target) {
                    end = mid - 1;
                } else {
                    if (left) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
