/**
 * @Author: WuFan
 * @Date: 2019/3/9 19:36
 */

package array;

import java.math.BigInteger;
import java.util.Scanner;

public class Tencent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();//子弹
//        int m =sc.nextInt();//气球颜色
//        int[] shot = new int[n];
//        for (int i = 0; i < n; i++) {
//            shot[i] = sc.nextInt();
//        }
        int n = 12, m = 5;
        int[] shot = new int[]{2,5 ,3 ,1 ,3 ,2 ,4, 1, 0, 5, 4 ,3};
        int start = 0;
        int[] shootnumber = new int[m];//射中的颜色个数
        int res = 0;
        for (int end = 0; end < n; end++) {
            if(shot[end]!=0){
                shootnumber[shot[end]-1]++;
            }
            int number = 0;
            for(int shoot_number:shootnumber){
                if(shoot_number>=1){
                    number++;
                }
            }
            if(number == m){
                boolean flag = true;
                while(flag && start <= end){
                    if(res==-1||res>end-start){
                        res = end-start+1;
                    }
                    shootnumber[shot[start]-1]--;
                    start++;
                    for(int shoot_number:shootnumber){
                        if(shoot_number==0){
                            flag =false;
                        }
                    }
                }

            }

        }

        System.out.println(res);

    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s =sc.nextInt();
        int[] niu = new int[n];
//        for (int i = 0; i < n; i++) {
//            niu[i] = sc.nextInt();
//        }
        if(n==s){
            System.out.println(1);
            return;
        }
        if(n<s){
            System.out.println(0);
            return;
        }
        int qdontwin = n-s;
        BigInteger res ;
        BigInteger nmul = new BigInteger("1");
        BigInteger n_smul=new BigInteger("1");
        BigInteger s_mul=new BigInteger("1") ;
        for (int i = 1; i <= n ; i++) {
            BigInteger num = new BigInteger(String.valueOf(i));
            nmul = nmul.multiply(num);
            if(i == qdontwin){
                n_smul = new BigInteger(nmul.toString());
            }
            if(i == s){
                s_mul = new BigInteger(nmul.toString());
            }

        }
        System.out.println("n的阶乘"+nmul);
        System.out.println("s的阶乘"+s_mul);
        System.out.println("n-s的阶乘"+n_smul);
        //res = (nmul/(s_mul*n_smul))*(int)Math.pow(2,qdontwin);
        res = nmul.divide(n_smul.multiply(s_mul));
        System.out.println(res);
        System.out.println((int)Math.pow(2,qdontwin));
        res = res.multiply(new BigInteger(String.valueOf((int)Math.pow(2,qdontwin))));//BigInteger.valueOf((int)Math.pow(2,qdontwin)));

        System.out.println(res.remainder(new BigInteger("1000000007")));


    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();
        if(!(1<=n && n<=100000 && m>=1 &&m <= 1000000000)){
            System.out.println(0);
        }
        int res = 0;
        System.out.println(m%n==0?m/n:m/n+1);

    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[][] lr = new int[q][2];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 2; j++) {
                lr[i][j] = sc.nextInt();
            }

        }
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            if((lr[i][1]-lr[i][0])%2==0){
                res[i] = lr[i][0]*((int)Math.pow(-1,lr[i][0]))+((lr[i][1]-lr[i][0])/2)*((int)Math.pow(-1,lr[i][0]));
            }else{
                res[i]= ((lr[i][1]-lr[i][0]+1)/2)*(-(int)Math.pow(-1,lr[i][0]));
            }
        }
        for (int i = 0; i < q; i++) {
            System.out.println(res[i]);
        }
    }
}
