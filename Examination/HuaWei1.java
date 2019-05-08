/**
 * @Author: WuFan
 * @Date: 2019/5/8 19:03
 */

package test360.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        //输入模块

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] number = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                number[i][j] = sc.nextInt();
            }

        }

        int M =sc.nextInt();//旋转次数
        if(N==0){
            System.out.println();
            return;
        }
        M = M % 4;
        if(M==0){
            print(number);
            return;
        }
        if(M==1){
            //对角线
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if(i!=j){
                        int temp = number[i][j];
                        number[i][j] = number[j][i];
                        number[j][i] = temp;
                    }
                }
            }
            //中线反转
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    int temp = number[i][j];
                    number[i][j] = number[i][N-j-1];
                    number[i][N-j-1] = temp;
                }
            }
            print(number);
            return;
        }
        if(M==2){
            //中线反转
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    int temp = number[i][j];
                    number[i][j] = number[i][N-j-1];
                    number[i][N-j-1] = temp;
                }
            }
            //横中反转
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = number[i][j];
                    number[i][j] = number[N-i-1][j];
                    number[N-i-1][j] = temp;
                }

            }
            print(number);
            return;
        }
        if(N==3){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    int temp = number[i][j];
                    number[i][j] = number[j][i];
                    number[j][i] = temp;
                }
            }
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = number[i][j];
                    number[i][j] = number[N-i-1][j];
                    number[N-i-1][j] = temp;
                }
            }
            print(number);
        }



    }
    private static void print(int[][] number){
        for (int i = 0; i <number.length ; i++) {
            for (int j = 0; j <number[0].length ; j++) {
                System.out.print(number[i][j]+" ");
            }
            System.out.println();
        }
    }

}
