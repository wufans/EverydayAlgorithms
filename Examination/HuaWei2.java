/**
 * @Author: WuFan
 * @Date: 2019/5/8 19:39
 */

package test360.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    //100%
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//礼物的数量
        int k =sc.nextInt();//小朋友数量
        if(k == 0){
            System.out.println(0);
            return;
        }
        helper(new ArrayList(), n, k, 0);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            ArrayList<Integer> temp_list = res.get(i);
            String temp_string= "";
            for (int j = 0; j < temp_list.size(); j++) {
                for (int l = 0; l < temp_list.get(j); l++) {
                    temp_string += "*";
                }
                temp_string+="|";
            }
            for (int j = 0; j < k-temp_list.size(); j++) {
                temp_string+="|";
            }

            System.out.println(temp_string.substring(0,temp_string.length()-1));
        }


    }
    public static void helper(ArrayList list, int gifts, int children, int temp_child){
        if(temp_child == children+1){
            return;
        }
        if(gifts == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = gifts; i >=0 ; i--) {
            list.add(i);
            helper(list,gifts-i,children,temp_child+1);
            list.remove(list.size()-1);
        }
    }

}
