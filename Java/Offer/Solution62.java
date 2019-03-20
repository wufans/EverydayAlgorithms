/**
 * @Author: WuFan
 * @Date: 2019/3/20 13:51
 */

package offer;

import java.util.Arrays;

/*
* 圆圈中最后剩下的数
* 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)*/
public class Solution62 {
    //约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。因为
    //是圆圈，所以最后需要对 n 取余。


    /*
    * 对约瑟夫环的讲解，可以参考：https://blog.csdn.net/u010429424/article/details/73695062
    * */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) /* 特殊输入的处理 */
            return -1;
        if (n == 1) /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }


    //My bad solution
    public static int LastRemaining_Solution2(int n, int m) {
        //m = m % n;
        int start = 0;
        if(n<=0 && m<=0){
            return -1;
        }
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <= m-1 ; j++) {
                while(flag[start]==true){
                    start = (start+1)%n;
                }
                if(j==m-1){
                    flag[start]=true;
                }
                start = (start+1)%n;
            }
            //System.out.println(Arrays.toString(flag));
        }
        for (int i = 0; i < n; i++) {
            if(flag[i]==false){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution2(6,7));
    }
}
