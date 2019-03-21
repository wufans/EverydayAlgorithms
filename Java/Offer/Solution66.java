/**
 * @Author: WuFan
 * @Date: 2019/3/21 14:33
 */

package offer;
/*
* 构建乘积数组
* 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。*/
public class Solution66 {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length<=1){
            return B;
        }
        int tempA = 1;
        for (int i = 0; i < length; i++) {
            B[i]=tempA;
            tempA*=A[i];
        }
        tempA=1;
        for (int i = length-1; i >=0 ; i--) {
            B[i]*=tempA;
            tempA*=A[i];
        }
        return B;
    }
}
