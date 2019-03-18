/**
 * @Author: WuFan
 * @Date: 2019/3/18 10:10
 */

package offer;
/*
* 数组中只出现一次的数字
* 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。*/

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution56 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //注意两个性质：
        //（1）异或的一个性质是：任何一个数字异或它自己都等于0。且异或运算满足交换律和结合律。
        //（2）两个相反数做“与”运算，得到两个数最右侧不为零的相同一位：
        /*
        *   1111 = -1    0000 = 0

          1110 = -2    0001 = 1

          1101 = -3    0010 = 2

          1100 = -4    0011 = 3

          1011 = -5    0100 = 4

          1010 = -6    0101 = 5

          1001 = -7    0110 = 6

          1000 = -8    0111 = 7*/

        //第一步，对每一个数做异或运算，因为相同的数异或后等0，所以最后的值为两个不同的数异或后的值。
        int diff = 0;
        for(int i :array){
            diff ^= i;
        }
        //第二步，对这个值与其负数做“与或”运算，得到最右侧不为零的一位
        diff &= -diff;
        //根据这个将所有数分成两组，一组该位为0，一组该位为1，这样能将这两个只出现奇数次的数分到不同的两个组合中。
        //第三步、将数组中分成两组的数分别“异或”，得到两个只出现奇数次的数。
        for(int i :array){
            if((diff & i) == diff){
                num1[0] ^= i;
            }else{
                num2[0] ^= i;
            }
        }

    }
}
