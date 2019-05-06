/**
 * @Author: WuFan
 * @Date: 2019/5/6 19:10
 */

package test360.pdd;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long K = sc.nextLong();
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += sc.nextLong();
        }
        long res = sum - (K-1)*N;
        if(res <=0){
            System.out.println(0);
        }else{
            System.out.println(res);
        }

    }
}
