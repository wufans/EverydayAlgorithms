/**
 * @Author: WuFan
 * @Date: 2019/4/3 20:34
 */

package test360;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int index = sc.nextInt();
//        int[] number = new int[index];
//        for (int i = 0; i < index; i++) {
//            number[i] = sc.nextInt();
//        }

        int index = Integer.valueOf(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int[] number = new int[index];
        for (int i = 0; i < index; i++) {
            number[i] = new Integer(s[i]);
        }

        int min = Integer.MAX_VALUE;
        for (int start = 1; start <= index; start++) {
            int min_temp = 0;
            for (int j = 1; j <= index; j++) {
                min_temp += Math.abs(number[(start+j-2)%index]-j);
            }
            min = min<min_temp?min:min_temp;
        }
        System.out.println(min);
    }
}
