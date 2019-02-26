/**
 * @Author: WuFan
 * @Date: 2019/2/26 18:14
 */

package offer;
/*
* 旋转数组的最小数字
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一
个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
* */
public class Solution11 {
    public int minNumberInRotateArray(int[] nums){
//        if(nums.length <1 || nums == null){
//            return 0;
//        }
//        else if(nums.length == 1){
//            return nums[0];
//        }
//        else{
//            for(int i = nums.length -1; i>=1 ;i--){
//                if(nums[i] < nums[i-1]){
//                    return nums[i];
//                }
//                if(i==1 && nums[1]==nums[0]){
//                    return nums[1];
//                }
//            }
//        }
//        return nums[0];
        //在一个有序数组中查找一个元素可以用二分查找，二分查找也称为折半查找，每次
        //都能将查找区间减半，这种折半特性的算法时间复杂度都为 O(logN)。
        //本题可以修改二分查找算法进行求解：
        //当 nums[m] <= nums[h] 的情况下，说明解在 [l, m] 之间，此时令 h = m；
        //否则解在 [m + 1, h] 之间，令 l = m + 1。
//        if (nums.length == 0)
//            return 0;
//        int l = 0, h = nums.length - 1;
//        while (l < h) {
//            int m = l + (h - l) / 2;
//            if (nums[m] <= nums[h])
//                h = m;
//            else
//                l = m + 1;
//        }
//        return nums[l];




//        如果数组元素允许重复的话，那么就会出现一个特殊的情况：nums[l] == nums[m]
//                == nums[h]，那么此时无法确定解在哪个区间，需要切换到顺序查找。例如对于数
//        组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h])
                return minNumber(nums, l, h);
            else if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }
    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }
}
