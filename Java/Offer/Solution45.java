/**
 * @Author: WuFan
 * @Date: 2019/3/14 16:05
 */

package offer;

import java.math.BigInteger;
import java.util.Arrays;

/*
* 把数组排成最小的数
*
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*
* 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是
   S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则
应该把 S2 排在前面。*/
public class Solution45 {
    //别人的简单方法
    public String PrintMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++)
            nums[i] = numbers[i] + "";
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String ret = "";
        for (String str : nums)
            ret += str;
        return ret;
    }


    public static void main(String[] args) {
        String s = PrintMinNumber(new int[]{3,2,4,3,5,1});
        System.out.println(s);
    }
    //用快排的方法
    public static String PrintMinNumber(int [] numbers) {
        //用快排
        quickSort(numbers,0,numbers.length-1);
        String res = "";
        for(int i:numbers)
            res+=i;
        return res;
    }
    public static void quickSort(int[] numbers,int left, int right){
        if(left<right){
            int index = partition(numbers,left,right);
            quickSort(numbers,left,index-1);
            quickSort(numbers,index+1,right);
        }
    }

    private static int partition(int[] numbers, int left, int right) {

        int start = left;
        int pivot = numbers[left];
        while(left < right){
            while(left<right && new BigInteger(numbers[right]+""+pivot).compareTo(new BigInteger(pivot+""+numbers[right]))>=0 )
                right--;
            while(left<right && new BigInteger(numbers[left]+""+pivot).compareTo(new BigInteger(pivot+""+numbers[left]))<=0)
                left++;
            if(left<right)
            {
                System.out.println("in");
                swap(numbers,left,right);
            }
        }
        swap(numbers,start,left);

        return left;
    }

    private static void swap(int[] numbers, int left, int right) {
        System.out.println(left + "  --  "+right);
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

}
