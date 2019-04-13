/**
 * @Author: WuFan
 * @Date: 2019/4/13 20:08
 */

package test360.testJD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class JDtest1 {
    public static void main(String[] args) {
        //past!
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();//节点的个数
        int[][] nodes = new int[number-1][2];
        for (int i = 0; i < number-1; i++) {
            for (int j = 0; j < 2; j++) {
                nodes[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < number-1 ; i++) {

            if(nodes[i][1] == 1){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nodes[i][0]);
                for (int j = i; j < number-1; j++) {
                    if(temp.contains(nodes[j][1])){
                        temp.add(nodes[j][0]);
                    }
                }
                int size = temp.size();
                res = res>size?res:size;
            }
        }

        System.out.println(res);



//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();//节点的个数
//        int[][] nodes = new int[number-1][2];
//        for (int i = 0; i < number-1; i++) {
//            for (int j = 0; j < 2; j++) {
//                nodes[i][j] = sc.nextInt();
//            }
//        }
//
//        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
//
//        for (int i = 0; i < number-1; i++) {
//            if(nodes[i][1] == 1 ){
//                ArrayList<Integer> objects = new ArrayList<>();
//                objects.add(nodes[i][0]);
//                temp.add(objects);
//            }else{
//                for(ArrayList a : temp){
//                    if(a.contains(nodes[i][1])){
//                        a.add(nodes[i][0]);
//                    }
//                }
//            }
//        }
//
//        int res = 0;
//        for(ArrayList a : temp){
//            res = a.size()>res?a.size():res;
//        }
//        System.out.println(res);



//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();//节点的个数
//        int[][] nodes = new int[number-1][2];
//        HashSet<Integer> left = new HashSet<>();
//        HashSet<Integer> right = new HashSet<>();
//        boolean flag = true;
//
//        for (int i = 0; i < number-1; i++) {
//            for (int j = 0; j < 2; j++) {
//                nodes[i][j] = sc.nextInt();
//                if(j==1 && nodes[i][j] == 1 && flag){
//                    left.add(nodes[i][j-1]);
//                    flag = false;
//                }else if(j==1 && nodes[i][j] == 1 && !flag){
//                    right.add(nodes[i][j-1]);
//                }
//            }
//        }
//        for (int i = 0; i < number-1; i++) {
//            if(left.contains(nodes[i][1])){
//                left.add(nodes[i][0]);
//            }else if(right.contains(nodes[i][1])){
//                right.add(nodes[i][0]);
//            }
//        }
//        System.out.println(Math.max(left.size(),right.size()));
    }
}
