/**
 * @Author: WuFan
 * @Date: 2019/3/12 19:00
 */

package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] testList = new int[]{-6,-3,-2,7,-15,1,2,2};
        int[] testList2 = new int[]{};
        System.out.println(Arrays.toString(maxSort(testList)));
    }
    public static int[] minSort(int[] list){
        if(list.length == 0 )
            return list;

        for (int i = 0; i < list.length-1; i++) {
            int min = list[i], indexMin = i;
            for (int j = i+1; j < list.length; j++) {
                if(list[j] < min){
                    min = list[j];
                    indexMin = j;
                }
            }
            if(list[i] > min){
                list[indexMin] = list[i];
                list[i] = min;
            }
        }
        return list;
    }
    public static int[] maxSort(int[] list){
        if(list.length == 0 )
            return list;
        for (int i = list.length- 1; i > 0 ; i--) {
            int maxIndex = i;
            for (int j = i -1  ; j >= 0 ; j--) {
                if(list[j] > list[maxIndex]){
                    maxIndex = j;
                }
            }
            if(list[maxIndex] > list[i]){
                int temp = list[i];
                list[i] = list[maxIndex];
                list[maxIndex] = temp;
            }
        }
        return list;
    }
}
