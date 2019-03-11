/**
 * @Author: WuFan
 * @Date: 2019/3/11 9:24
 */

package offer;

import java.util.*;

/*
* 字符流中第一个不重复的字符
*
 *  请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。*/
public class Solution41_2 {
    //用map和list实现
    private Map<Character,Integer> temp = new HashMap<>();
    private ArrayList<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        list.add(ch);
        if(temp.containsKey(ch)){
            temp.put(ch,temp.get(ch)+1);

        }else{
            temp.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(char c:list){
            if(temp.get(c) == 1){
                return c;
            }
        }
        return '#';
    }


    //用队列实现
    private Queue<Character> res = new LinkedList<>();
    private int[] count = new int[256];
    //Insert one char from stringstream
    public void Insert2(char ch)
    {
        count[ch]++;
        res.offer(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce2()
    {
        while(!res.isEmpty()){
            if(count[res.peek()] == 1){
                return res.element();
            }else{
                res.poll();
            }
        }
        return '#';
    }
}
