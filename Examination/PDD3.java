/**
 * @Author: WuFan
 * @Date: 2019/5/6 19:22
 */

package test360.pdd;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int min = 0;
        int max = 0;

        int[][] lines = new int[n][2];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < 2; j++) {
                lines[i][j] = sc.nextInt();
                min = Math.min(min,lines[i][j]);
                max = Math.max(max,lines[i][j]);
            }
        }

        int[] temp = new int[max-min];

        for (int i = 0; i <n ; i++) {
            for (int j = lines[i][0]; j <lines[i][1] ; j++) {
                temp[j-min] += 1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;

        int start = 0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] < k){
                if(i != start){
                    res.add(start+min);
                    res.add(i+min);
                    count++;
                    start = i+1;
                }else{
                    start ++;
                }
            }else{
                if(i == temp.length-1){
                    res.add(start+min);
                    res.add(i+min+1);
                    count++;
                }else{
                    continue;
                }
            }
        }

        System.out.println(count);
        for (int i = 0; i < res.size(); i+= 2) {
            System.out.println(res.get(i)+" "+res.get(i+1));
        }


    }
}
