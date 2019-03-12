/**
 * @Author: WuFan
 * @Date: 2019/3/12 20:37
 */

package sorting;

import java.util.Arrays;
/*
* 归并排序利用的是分治的思想实现的，对于给定的一组数据，利用递归与分治技术将数据序列划分成为越来越小的子序列，之后对子序列排序，最后再用递归方法将排好序的子序列合并成为有序序列。合并两个子序列时，需要申请两个子序列加起来长度的内存，临时存储新的生成序列，再将新生成的序列赋值到原数组相应的位置。
*/
public class MergeSort {
    public static void main(String[] args) {
        int[] testList = new int[]{-6,-3,-2,7,-15,1,2,2};
        int[] testList2 = new int[]{};
        System.out.println(Arrays.toString(mergeSort(testList,0,testList.length-1)));
    }

    private static int[] mergeSort(int[] testList,int left,int right) {
        if(left<right){
            mergeSort(testList,left,(left+right)/2);
            mergeSort(testList,(left+right)/2+1,right);
            merge(testList,left,(left+right)/2,right);
        }
        return testList;
    }
    private static void merge(int[] testList, int left, int middle, int right){
        int[] temp = new int[right - left + 1];//ps：也可以从开始就申请一个与原数组大小相同的数组，因为重复new数组会频繁申请内存
        int i = left;
        int j = middle+1;
        int k = 0;
        while(i<=middle&&j<=right){
            if (testList[i] < testList[j]) {
                temp[k++] = testList[i++];
            } else {
                temp[k++] = testList[j++];
            }
        }
        while(i<=middle){//将左边剩余元素填充进temp中
            temp[k++] = testList[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[k++] = testList[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            testList[k2 + left] = temp[k2];
        }

    }

}
