/**
 * @Author: WuFan
 * @Date: 2019/5/6 19:04
 */

package test360.pdd;

import java.util.Scanner;
import java.util.Stack;

/*
* */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if(stack.isEmpty()){
                stack.push(chars[i]);
            }else{
                if(stack.peek() == chars[i]){
                    res++;
                    stack.pop();
                }else{
                    stack.push(chars[i]);
                }
            }
        }
        System.out.println(res);
    }
}
