/**
 * @Author: WuFan
 * @Date: 2019/3/19 21:13
 */

package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*滑动窗口的最大值
* 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。*/
public class Solution59 {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(num.length<=0 || num.length<size || size == 0){
            return res;
        }
        PriorityQueue<Integer> temp = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            temp.add(num[i]);
        }
        for (int i = size; i < num.length; i++) {
            res.add(temp.peek());
            temp.remove(num[i-size]);
            temp.add(num[i]);
        }
        res.add(temp.peek());
        return res;

    }

    public static void main(String[] args) {
        System.out.println(maxInWindows(new int[]{2,3,4,2,6,2,5,1},3));
    }
}
