/**
 * @Author: WuFan
 * @Date: 2019/4/10 10:30
 */

package leetcode;

import java.util.Arrays;

/*
* Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
*/
/*排序问题*/
public class Solution75 {
    public static void main(String[] args) {
//        int[] t = new int[]{2,0,2,1,1,0};
        int[] t = new int[]{2,0,1};
        sortColors(t);
        System.out.println(Arrays.toString(t));
    }
    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
    public static void quickSort(int[] nums, int start, int end){
        if(end > start){
            int i = partition(nums, start, end);
            quickSort(nums, start, i-1);
            quickSort(nums, i+1, end);
        }
    }
    public static int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int i = start;
        int j = end;
        while(i<j){
            while(i<j && nums[j]>= pivot){
                j--;
            }
            while(i<j && nums[i]<= pivot){
                i++;
            }
            if(i<j){
                swap(nums,i,j);
            }
        }
        if(i != start){
            swap(nums, start, i);
        }
        return i;
    }
    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
/*
*
* some other solutions*/
    public void sortColors2(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }
}
