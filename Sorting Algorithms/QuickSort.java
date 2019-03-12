/**
 * @Author: WuFan
 * @Date: 2019/3/12 21:08
 */

package sorting;

import java.util.Arrays;
/*
* 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
*
* 其中，partition主要有两种方法：
* A.先把选定为pivot的元素放到最后，然后设定指针low和指针high，low指针左移，high指针右移，当两个指针相撞后停止移动。期间如果符合交换条件，两元素交换。最后把pivot元素放到中间。
* B.类似冒泡排序的思路，把比pivot大的元素“往下沉”，把比pivot小的元素“往上浮”。*/
public class QuickSort {
    public static void main(String[] args) {
        int[] testList = new int[]{-6,-3,-2,7,-15,1,2,2};
        int[] testList2 = new int[]{};
        System.out.println(Arrays.toString(quickSort2(testList,0,testList.length-1)));
    }
    //A
    private static int[] quickSort(int[] testList, int start, int end) {
        if (testList == null || start >= end)
            return testList;
        int i = start, j = end;
        int pivotKey = testList[start];
        while (i < j) {
            while (i < j && testList[j] >= pivotKey)
                j--;
            if (i < j)
                testList[i++] = testList[j];
            while (i < j && testList[i] <= pivotKey)
                i++;
            if (i < j)
                testList[j--] = testList[i];
        }
        testList[i] = pivotKey;
        quickSort(testList, start, i - 1);
        quickSort(testList, i + 1, end);
        return testList;
    }

    //--------------------------------------------------------------------------------------------------
    //B
    public static int[] quickSort2(int[] testList, int start, int end) {
        if (testList == null || start < 0 || end > testList.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (start == end) return testList;
        int index = partition(testList, start, end);
        if (index > start) {
            quickSort2(testList, start, index - 1);
        }
        if (index < end) {
            quickSort2(testList, index + 1, end);
        }
        return testList;
    }

    private static int partition(int[] testList, int start, int end) {
        int index = start + (int)(Math.random() * (end - start + 1));
        swap(testList, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (testList[index] < testList[end]) {
                small++;
                if (small != index) {
                    swap(testList, index, small);
                }
            }
        }
        swap(testList, small + 1, end);
        return small + 1;
    }

    private static void swap(int[] testList, int i, int j){
        int temp = testList[i];
        testList[i] = testList[j];
        testList[j] = temp;
    }

}
