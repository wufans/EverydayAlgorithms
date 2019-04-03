/**
 * @Author: WuFan
 * @Date: 2019/4/3 20:49
 */

package test360;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Integer[] number = new Integer[N];
        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }
        int[][] operat = new int[M][2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 2; j++) {
                operat[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            if(operat[i][0] == 0){
                Arrays.sort(number,0,operat[i][1]);
            }else{
                Arrays.sort(number,0,operat[i][1],(o1,o2)->o2-o1);
            }
            System.out.println(Arrays.toString(number));
        }

    }
}
