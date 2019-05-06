/**
 * @Author: WuFan
 * @Date: 2019/5/6 19:57
 */

package test360.pdd;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] high = new int[M];
        for (int i = 0; i < M ; i++) {
            high[i] = sc.nextInt();
        }

        Arrays.sort(high);


        int[] res = new int[M-N+1];
        int res_num = 0;

        for (int i = 0; i < N; i++) {
            res[0] += (high[N-1] - high[i]);
            res_num = res[0];
        }


        for (int i = N; i < M ; i++) {
            res[i-N+1] = res[i-N];
            res[i-N+1] += (high[i] - high[i-1])*N;
            res[i-N+1] -= (high[i] - high[i-N]);
            res_num = Math.min(res[i-N+1],res_num);
        }
        System.out.println(res_num);

    }
}
