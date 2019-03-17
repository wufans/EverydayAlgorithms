/**
 * @Author: WuFan
 * @Date: 2019/3/17 14:51
 */

package offer;
/*
* 数字在排序数组中出现的次数
* 统计一个数字在排序数组中出现的次数。*/
public class Solution53 {
    //二分查找
    public int GetNumberOfK(int [] array , int k) {
        int head = binarySearch(array, k);
        int end = binarySearch(array,k+1);
        return (head == array.length || array[head] != k) ? 0 : end
                - head;
    }

    private int binarySearch(int[] array, int k) {
        int l = 0, h = array.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (array[m] >= k)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
}
