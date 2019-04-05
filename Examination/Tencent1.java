/**
 * @Author: WuFan
 * @Date: 2019/4/5 19:54
 */

package test360.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Tencent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt(); //需要的总数
        int number = sc.nextInt();//钱币的种类
        int[] values = new int[number];
        for (int i = 0; i < number ; i++) {
            values[i] = sc.nextInt();
        }
        Arrays.sort(values);
        if(values[0]!=1){
            System.out.println(-1);
            return;
        }
        int[] dp = new int[money+1]; //存储当前的可能解，dp[0]表示钱数为1
        HashMap<Integer,Integer>[] res = new HashMap[money+1];

        for(int value:values){
            if(value<=money){
                dp[value] = 1;
                HashMap<Integer,Integer> res_temp = new HashMap<>();
                res_temp.put(value,1);
                res[value] = res_temp;
            }
        }



        for (int i = 2; i <= money ; i++) {
            if(dp[i]==1){
                continue;
            }
            for (int j = number-1; j >=0 ; j--) {
                if (i > values[j]) {
                    dp[i] = dp[i-values[j]] + 1;
                    HashMap<Integer,Integer> res_temp = new HashMap<>(res[i-values[j]]);
                            //res[i-values[j]];
                    if(res_temp.containsKey(values[j])){
                        res_temp.put(values[j],res_temp.get(values[j])+1);
                    }else{
                        res_temp.put(values[j],1);
                    }
                    res[i] = res_temp;
                    break;
                }
                if (j == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        //统计用到的最大值
        int[] count = new int[number];
        for (int i = 1; i <= money; i++) {
            //System.out.println(res[i]);
            for (int j = 0; j < number; j++) {
                if(res[i].containsKey(values[j])){
                    count[j] = Math.max(count[j],res[i].get(values[j]));
                }
            }
        }
        int rescount = 0;
        for(int t : count){
            rescount+=t;
        }
        System.out.printf(Arrays.toString(count));
        System.out.println(rescount);
//        System.out.println(dp[money]);
//        System.out.println(Arrays.toString(dp));
    }
}
