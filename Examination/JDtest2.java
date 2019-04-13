/**
 * @Author: WuFan
 * @Date: 2019/4/13 19:32
 */

package test360.testJD;

import java.util.HashSet;
import java.util.Scanner;

public class JDtest2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[]  strings= new String[number];
        for (int i = 0; i < number; i++) {
            strings[i] = sc.next();
        }
        String T = sc.next();

        if(number <= 0){
            System.out.println(0);
            return;
        }

        int[] dp = new int[T.length()];
        dp[0] = 0;
        for (int i = 0; i < T.length(); i++) {
            for(String s:strings){
                if(s.length() <= i){
                    String temp = T.substring(i+1-s.length(),i+1);
                    if(temp.equals(s)){
                        dp[i] = Math.max(dp[i],dp[i-s.length()]+1);
                    }
                }
            }
        }
        System.out.println(dp[T.length()-1]);

//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        String[]  strings= new String[number];
//        for (int i = 0; i < number; i++) {
//            strings[i] = sc.next();
//        }
//        String T = sc.next();
//
//        if(number <= 0){
//            System.out.println(0);
//            return;
//        }
//        //处理部分
//        int start = 0, end = 1;
//        int res = 0;
//        while(end<=T.length()){
//            String temp = T.substring(start,end);
//            for(String s : strings){
//                if(s.equals(temp)){
//                    res++;
//                    start = end;
//                    break;
//                }
//            }
//            end ++;
//        }
//        System.out.println(res);












//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        int[]  strings= new int[number];
//        for (int i = 0; i < number; i++) {
//            strings[i] = sc.next().hashCode();
//        }
//        String T = sc.next();
//
//        if(number <= 0){
//            System.out.println(0);
//            return;
//        }
//        //处理部分
//        int start = 0, end = 1;
//        int res = 0;
//        while(end<=T.length()){
//            int temp = T.substring(start,end).hashCode();
//            for(int s : strings){
//                if(s == temp){
//                    res++;
//                    start = end;
//                    break;
//                }
//            }
//            end ++;
//        }
//        System.out.println(res);





        /*
        * -----------------------------------------------------*/
        //输入部分
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        HashSet<Integer> strings = new HashSet<>();
//        for (int i = 0; i < number; i++) {
//            strings.add(sc.next().hashCode());
//        }
//        String T = sc.next();
//
//        if(number <= 0){
//            System.out.println(0);
//            return;
//        }
//        //处理部分
//        int start = 0, end = 1;
//        int res = 0;
//        while(end<=T.length()){
//            String temp = T.substring(start,end);
//            if(strings.contains(temp.hashCode())){
//                res++;
//                start = end;
//                end++;
//            }else{
//                end ++ ;
//            }
//
//        }
//        System.out.println(res);

    }
}
