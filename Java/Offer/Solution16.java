/**
 * @Author: WuFan
 * @Date: 2019/2/28 16:36
 */

package offer;
/*
* 数值的整数次方
* 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的
exponent 次方。*/
public class Solution16 {
//    public double Power(double base, int exponent){
//        //错误且没考虑周全的做法
//        double result = 1.0;
//        for(int i = 1;i<= exponent;i++){
//            result = result*base;
//        }
//        return result;
//    }

    //-----------------------------------//
//    public double Power2(double base, int exponent) throws Exception {
//        //全面但时间复杂度很高的做法
//        double result = 0.0;
//        if(equal(base,0.0) && exponent<0){
//            throw new Exception("0的负数次幂无意义");
//        }
//        if(equal(exponent,0)){
//            return 1.0;
//        }
//        if(exponent <0){
//            result= powerWithExponent(1.0/base, -exponent);
//        }
//        else{
//            result = powerWithExponent(base,exponent);
//        }
//        return result;
//    }
//    private double powerWithExponent(double base,int exponent){
//        double result = 1.0;
//        for(int i = 1;i<= exponent;i++){
//            result = result*base;
//        }
//        return result;
//    }
//    //判断两个double型数据，计算机有误差
//    private boolean equal(double num1,double num2){
//        if((num1-num2>-0.0000001) && (num1-num2<0.0000001)){
//            return true;
//        }else{
//            return false;
//        }
//    }


    //最优解
    public double Power(double base,int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;
    }

}
