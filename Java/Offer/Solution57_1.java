/**
 * @Author: WuFan
 * @Date: 2019/3/18 11:27
 */

package offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 和为 S 的两个数字
*
* 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    输出描述:
    对应每个测试案例，输出两个数，小的先输出。

    注意：当一个有序的序列，对于和相等的两个数相隔越远，最后得到的数乘积最小。*/
public class Solution57_1 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum)
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            if (cur < sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }

}
