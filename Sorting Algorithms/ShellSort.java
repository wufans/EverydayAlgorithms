/**
 * @Author: WuFan
 * @Date: 2019/3/12 19:44
 */

package sorting;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] testList = new int[]{-6,-3,-2,7,-15,1,2,2};
        int[] testList2 = new int[]{};
        System.out.println(Arrays.toString(shellSort(testList)));
    }

    private static int[] shellSort(int[] testList) {
        for (int gap = testList.length/2; gap >= 1; gap/=2) {
            //对子序列插入排序
            for (int i = gap; i < testList.length; i++) {
                int j = i;
                int current = testList[i];
                while(j-gap>=0 && testList[j-gap]>current){
                    testList[j] = testList[j-gap];
                    j-=gap;
                }
                testList[j] = current;
            }
        }
        return testList;
    }
}
