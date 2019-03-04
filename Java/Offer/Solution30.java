/**
 * @Author: WuFan
 * @Date: 2019/3/4 20:57
 */

package offer;
/*
* 包含 min 函数的栈
* 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。*/

import java.util.Stack;

public class Solution30 {
    private Stack<Integer> datastack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();


    public void push(int node) {
        datastack.push(node);
        if(minstack.isEmpty()){
            minstack.push(node);
        }else{
            if(minstack.peek()<node){
                minstack.push(minstack.peek());
            }else{
                minstack.push(node);
            }
        }
    }

    public void pop() {
        datastack.pop();
        minstack.pop();

    }

    public int top() {
        return datastack.peek();
    }

    public int min() {
        return minstack.peek();
    }
}
