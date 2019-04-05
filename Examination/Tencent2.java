/**
 * @Author: WuFan
 * @Date: 2019/4/5 20:24
 */

package test360.tencent;

import java.util.Scanner;

public class Tencent2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int number1 = 0;
        int number0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                number0++;
            }else{
                number1++;
            }
        }
        System.out.println(Math.abs(number0-number1));
    }
}
