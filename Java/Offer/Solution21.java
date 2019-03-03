/**
 * @Author: WuFan
 * @Date: 2019/3/3 15:23
 */

package offer;
/*
* 调整数组顺序使奇数位于偶数前面
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半
* 部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
public class Solution21 {
    public void reOrderArray(int[] nums){
        //在原数组的基础上修改
//        if(nums == null || nums.length == 0 || nums.length == 1){
//            return;
//        }
//        int start = 0, end = 0;
//        while(start < nums.length -1 ){
//
//            if(nums[start] % 2 == 1){
//                start++;
//            }else{
//                end = start + 1;
//                while(end < nums.length){
//                    if(nums[end] % 2 == 1){
//                        break;
//                    }else{
//                        end++;
//                    }
//                }
//                if(end == nums.length){
//                    return;
//                }else{
//                    for (int i = end; i > start ; i--) {
//                        int tmp = nums[i];
//                        nums[i] = nums[i-1];
//                        nums[i-1] = tmp;
//                    }
//                }
//
//            }
//        }
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums)
            if (val % 2 == 1)
                oddCnt++;
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }
}
