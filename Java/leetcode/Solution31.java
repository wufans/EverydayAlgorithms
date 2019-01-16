/**
 * @Author: WuFan
 * @Date: 2019/1/15 17:26
 */

package leetcode;
/*
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/

/*
* 比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
2) 接下来分两种情况：
    (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
    (2) 否则，如果p存在，从p开始往后找，找找找，找到第一个比他小的数，然后两个调换位置，比如例子中的4。调换位置后得到(2,4,6,5,3,1)。最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。
以上方法中，最坏情况需要扫描数组三次，所以时间复杂度是O(3*n)=O(n)，空间复杂度是O(1)。*/
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        //长度为1的数组
        if (nums.length == 1) {
            return;
        }

        //从后向前找到第一个不满足逆序的元素
        int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; --i); //注意，这里有=，可以排除含有重复元素的情况

        //从i+1位置开始，向后查找比nums[i]大的最小元素
        if(i >= 0){
            int j = i + 1;
            for(; j < nums.length && nums[j] > nums[i]; ++j);
            swap(nums,i,j - 1); //交换，注意是同 j - 1交换
        }

        //将i之后的元素逆置(这里包含一种特殊情况，若该排列已经是字典序中的最大了，则下一个序列应该是最小字典序，因此，直接在这里逆置即可)
        int k = nums.length - 1;
        i++;
        for(; i < k; i++, k--)
            swap(nums, i, k);
    }

    /**
     * 交换元素
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array,int i ,int j){
        //交换
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
