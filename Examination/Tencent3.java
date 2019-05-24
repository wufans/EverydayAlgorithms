package leetcode;

/**
 * @author wufan77
 * @date 2019/5/24 11:21
 */
public class TestTencent {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int n = 6;
        int[] time = new int[]{10,11,12,13,14,15};
        int v = 5;
        System.out.println(getTime(n,time,v));
    }
    public static int getTime(int n,int[] time, int v){

        int res = 0;
        res += 150/v;
        for(int i = 0;i <= time.length-1;i++){
//            System.out.println("第"+(i+1)+"个红绿灯:"+res);
            int times = res/time[i];
            if(times %2 == 1){
                res += (time[i]*(times+1)-res);
//                System.out.println("等红灯中。。"+res);
            }

            res += (150/v);
        }


        return res;

    }
}
