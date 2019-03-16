/**
 * @Author: WuFan
 * @Date: 2019/3/16 16:57
 */

package offer;
/*
* 数组中的逆序对
* 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007*/
public class Solution51 {
    public static int InversePairs(int [] array) {
        //直接法
        //算法超时？
        long res = 0;
        int start = 0 ;
        int end = array.length-1;
        while(start<array.length-1){
            while(start<end){
                if(array[start]>array[end])
                    res+=1;
                end--;
            }
            start++;
            end = array.length-1;
        }
        return (int) (res % 1000000007);

    }
    //利用归并排序的方法
    private long cnt = 0;
    private int[] tmp; // 在这里声明辅助数组，而不是在 merge() 递归函数中声明
    public int InversePairs2(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);//模1000000007，可以保证值永远在int的范围内。
    }
    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }
    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            else if (nums[i] < nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                this.cnt += m - i + 1; // nums[i] >= nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }
            k++;
        }
        for (k = l; k <= h; k++)
        nums[k] = tmp[k];
    }
    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{}));
    }
}
