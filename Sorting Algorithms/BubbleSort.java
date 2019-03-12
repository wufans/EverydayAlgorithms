 /**
 * @Author: WuFan
 * @Date: 2019/3/12 18:45
 */

package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] testList = new int[]{-6,-3,-2,7,-15,1,2,2};
        int[] testList2 = new int[]{};
        for (int i = testList.length-1; i >= 1 ; i--) {
            for (int j = 0; j < i; j++) {
                if(testList[j]>testList[j+1]){
                    int temp = testList[j];
                    testList[j] = testList[j+1];
                    testList[j+1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(testList));
    }
}
