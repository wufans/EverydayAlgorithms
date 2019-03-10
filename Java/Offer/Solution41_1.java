/**
 * @Author: WuFan
 * @Date: 2019/3/10 21:16
 */

package offer;

import java.util.PriorityQueue;
import java.util.Stack;

/*
*  数据流中的中位数
*
*  如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。*/
public class Solution41_1 {
    //用两个栈实现的
    Stack<Integer> min = new Stack<>();
    Stack<Integer> max = new Stack<>();
    int number = 0;
    public void Insert(Integer num) {

        number++;
        if(min.size() == 0 && (max.size() == 0 || num <= max.peek())){
            min.push(num);
            return;
        }
        if(max.size() == 0 && (min.size() == 0 || num >= min.peek())){
            max.push(num);
            return;
        }
        if(num > max.peek()){
            while(max.size() != 0 && num>max.peek()){
                min.push(max.pop());
            }
        }
        if(num < min.peek()){
            while( min.size() != 0&& num<min.peek() ){
                max.push(min.pop());
            }
        }
        min.push(num);
    }

    public Double GetMedian() {
        while(min.size()<number/2){
            min.push(max.pop());
        }
        while(min.size()>number/2){
            max.push(min.pop());
        }
        if(number%2==0){
            return (min.peek()+max.peek())/2.0;
        }
        else{
            return (double)max.peek();
        }
    }

    //用堆实现的
    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;
    public void Insert2(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
/* N 为偶数的情况下插入到右半边。
* 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素
来的大，
* 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆
顶元素即为最大元素，此时插入右半边 */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        } N
                ++;
    }
    public Double GetMedian2() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }

    public static void main(String[] args) {
        Solution41_1 test = new Solution41_1();
        test.Insert(1);
        test.Insert(2);
        test.Insert(3);
        test.Insert(4);
        test.Insert(3);

        System.out.println(test.GetMedian());

    }
}
