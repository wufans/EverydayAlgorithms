/**
 * @Author: WuFan
 * @Date: 2019/2/28 16:15
 */

package offer;
/*
* 二进制中 1 的个数
* 输入一个整数，输出该数二进制表示中 1 的个数。*/
public class Solution15 {
    //这个方法不对，当n=-2147483648不能通过，因为如果是负数，比如0x80000000，如果一直做右移运算，最终这个数字就会变成0xFFFFFFFF而陷入死循环。
//    public int NumberOf1(int n){
//        int res = 0;
//        while( n>0){
//            if((n&1)==1){
//                res++;
//            }
//            n>>=1;
//        }
//        return res;
//    }

    /*
    * 该位运算去除 n 的位级表示中最低的那一位。
    * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
        n :   10110100
        n-1 : 10110011
        n&(n-1) : 10110000*/
    public int NumberOf2(int n){
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
    //可以直接用bitcount计算。
    //对于这部分代码参考可以下面：
    // //https://blog.csdn.net/zhouzipeng000/article/details/56676885
//    i = i - ((i >>> 1) & 0x55555555);
//    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
//    i = (i + (i >>> 4)) & 0x0f0f0f0f;
//    i = i + (i >>> 8);
//    i = i + (i >>> 16);
//        return i & 0x3f;
    public int NumberOf3(int n) {
        return Integer.bitCount(n);
    }
    public static void main(String args[]){
        Solution15 test = new Solution15();
        //System.out.println(test.NumberOf1(8));

//        String b = "abc";
//        String c = "abc";
//        String s = new String("abc");
//        System.out.println(s==c);
    }
}
