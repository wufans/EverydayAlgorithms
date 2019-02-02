/**
 * @Author: WuFan
 * @Date: 2019/2/2 11:30
 */

package leetcode;

/*
* Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].*/
public class Solution704 {
    public int search(int[] nums, int target) {

        //This soluton beats 100%
        if(nums[0]>target || nums[nums.length-1]<target){
            return -1;
        }
        if(nums.length == 1){
            return nums[0]==target?0:-1;
        }
        int mid;
        int left = 0;
        int right = nums.length-1;
        while(left < right){ //关键就是这里的这个边界条件，如果是大约等于，那么就会简单很多！
            mid = (left + right)/2;
            if(mid == left){
                if(nums[mid] == target){
                    return mid;
                }else if(nums[right] == target){
                    return right;
                }else{
                    return -1;
                }
            }
            if (target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right = mid;
            }else{
                left = mid;
            }
        }
        return -1;

//
//        int low = 0;
//        int high = nums.length -1;
//        int mid;
//
//        while(low<=high){
//            mid = (low+high)/2;
//
//            if(nums[mid] == target){
//                return mid;
//            }
//            if(nums[mid] < target){
//                low = mid+1;
//            }
//            else{
//                high = mid-1;
//            }
//        }
//        return -1;
    }
}
