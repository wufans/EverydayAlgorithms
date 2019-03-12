/**
 * @Author: WuFan
 * @Date: 2019/3/12 19:18
 */

package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] testList = new int[]{-6,-3,-2,7,-15,1,2,2};
        int[] testList2 = new int[]{};
        System.out.println(Arrays.toString(insertSort(testList)));
    }
    public static int[] insertSort(int[] list){
        if(list.length<=1){
            return list;
        }
        for (int i = 1; i < list.length ; i++) {
            int temp = list[i];
//            for (int j = i-1; j >= 0; j--) {
//                if(list[j]>temp){
//                    list[j+1] = list[j];
//                    if(j == 0)
//                        list[0] = temp;
//                }else{
//                    list[j+1] = temp;
//                    break;
//                }
//            }
            int index = i-1;
            while(index>=0 && list[index]>temp){
                list[index+1] = list[index];
                index --;
            }
            list[index+1] = temp;
        }
        return list;
    }
}
