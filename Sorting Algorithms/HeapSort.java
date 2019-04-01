/**
 * @Author: WuFan
 * @Date: 2019/3/20 16:28
 */

package sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] testList = new int[]{-6,-3,-2,7,-15,1,2,2};
        heapsort(testList);
        System.out.println(Arrays.toString(testList));
    }
    public static void heapify(int[] list, int currentindex, int length){
        if (currentindex < length) {
            int left = 2 * currentindex + 1;
            int right = 2 * currentindex + 2;
            int max = currentindex;
            if (left <= length) {
                if (list[max] < list[left]) {
                    max = left;
                }
            }
            if (right <= length) {
                if (list[max] < list[right]) {
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if (max != currentindex) {
                int temp = list[max];
                list[max] = list[currentindex];
                list[currentindex] = temp;
                heapify(list, max, length);
            }
        }
    }
    public static void swap(int[] list,int index1, int index2){
        int temp = list[index2];
        list[index2]= list[index1];
        list[index1] = temp;
    }
    public static void buildheap(int[] list){
        for (int i = list.length-1; i >= 0 ; i--) {
            heapify(list,i,list.length-1);
        }
    }
    public static void heapsort(int[] list){
        buildheap(list);
        System.out.println(Arrays.toString(list));
        for (int i = list.length-1; i >= 1 ; i--) {
            swap(list,i,0);
            heapify(list,0,i-1);
        }
    }

}
