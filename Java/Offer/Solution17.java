/**
 * @Author: WuFan
 * @Date: 2019/3/1 17:08
 */

package offer;
/*
* 打印从 1 到最大的 n 位数
* 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出
1、2、3 一直到最大的 3 位数即 999。*/


public class Solution17 {
    //错误的做法
//    static void print1ToMaxOfNDigits(int n){
//        int max_num = (int)Math.pow(10,n) -1;
//        for (int i = 1; i <= max_num ; i++) {
//            System.out.print(i);
//        }
//    }
//
//    public static void main(String[] args) {
//        print1ToMaxOfNDigits(2);
//    }
    //由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }
    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }
    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
