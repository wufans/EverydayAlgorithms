/**
 * @Author: WuFan
 * @Date: 2019/4/3 19:38
 */

package test360;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int[][] people = new int[index][4];
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < 4; j++) {
                people[i][j] = sc.nextInt();
            }
        }
        int[] res = new int[index];
        for (int i = 0; i < index; i++) {
            int resi = 0;
            resi += people[i][3];
            //三人队伍数量小于一人队伍的数量
            if(people[i][2]<=people[i][0]){
                resi += people[i][2];
                people[i][0] -= people[i][2];
            }else{
                resi += people[i][0];
            }
            resi+=people[i][1]/2;
            //一人队伍有人
            if(people[i][0] >=2){
                if(people[i][1]%2==1){
                    resi = resi +1 + (people[i][0]-2)/4;
                }else{
                    resi = resi + (people[i][0])/4;
                }
            }
            res[i] = resi;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }
    }
}
