/**
 * @Author: WuFan
 * @Date: 2019/2/26 0:01
 */

package offer;

import java.util.Stack;

/*
* 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
* */
public class Solution9 {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();
    void push(Integer in){
        inStack.push(in);
    }
    Integer pop() throws Exception {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        if(outStack.isEmpty()){
            throw new Exception("no data");
        }
        return outStack.pop();
    }

    public static void main(String[] args) throws Exception {
        Solution9 test = new Solution9();
        test.push(8);
        test.push(9);
        test.push(99);
        System.out.println(test.pop());
        test.push(999);


    }
}
