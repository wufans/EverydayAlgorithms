/**
 * @Author: WuFan
 * @Date: 2019/5/8 20:16
 */

package test360.huawei;

import java.util.Scanner;

public class Test3 {
    //20%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] content = new String[2*N];
        for (int i = 0; i < 2*N; i++) {
            content[i] = sc.next();
        }


        int res = 0;
        for (int i = 0; i < N; i++) {
            int temp_max = compare(content[i].toCharArray(),content[i+N].toCharArray(),0,0);
            res += Math.max(content[i].length()-temp_max,content[i+N/2].length()-temp_max);
            System.out.println(res);
        }
        System.out.println(res);

    }

    //得到两个字符串最大的相同位数
    public static int compare(char[] a, char[] b, int index_of_a, int index_of_b){
        if(index_of_a == a.length || index_of_b == b.length){
            return 0;
        }

        int temp_number  = 0;
        if(a[index_of_a] == b[index_of_b]){
            temp_number = Math.max(compare(a,b,index_of_a,index_of_b+1),compare(a,b,index_of_a+1,index_of_b));
            return Math.max(temp_number,1+compare(a,b,index_of_a+1,index_of_b+1));
        }else{
            temp_number = Math.max(compare(a,b,index_of_a,index_of_b+1),compare(a,b,index_of_a+1,index_of_b));
            return Math.max(temp_number,compare(a,b,index_of_a+1,index_of_b+1));
        }
    }
}
