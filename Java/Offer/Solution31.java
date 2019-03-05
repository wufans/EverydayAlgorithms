/**
 * @Author: WuFan
 * @Date: 2019/3/5 19:22
 */

package offer;
/*
*栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列
 * 的弹出序列。（注意：这两个序列的长度是相等的） */
import java.util.Stack;

public class Solution31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null){
            return false;
        }
        if(pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for(int indexpush = 0,indexpop = 0;indexpush <pushA.length;indexpush++){
            stack.push(pushA[indexpush]);
            while(indexpop < popA.length && popA[indexpop] == stack.peek()){ //这里注意一个条件是，栈的元素是不同的！如果可以相同，则不能这么做。
                stack.pop();
                indexpop++;
            }
        }
        return stack.isEmpty();
    }
}
