/**
 * @Author: WuFan
 * @Date: 2019/3/5 21:16
 */

package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
* 按之字形顺序打印二叉树
* 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。*/
public class Solution32_3 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        if(pRoot == null)
            return res;
        Queue<TreeNode> tree = new LinkedList<>();
        tree.add(pRoot);
        boolean flag = true;
        while(!tree.isEmpty()){
            ArrayList temp = new ArrayList();
            int count = tree.size();
            while(count >0){
                TreeNode t = tree.poll();
                temp.add(t.val);
                if(t.left != null){
                    tree.add(t.left);
                }
                if(t.right != null)
                    tree.add(t.right);
                count--;
            }
            if(flag){
                res.add(temp);
            }else{
                Collections.reverse(temp);
                res.add(temp);
            }
            flag = ! flag;
        }
        return res;
    }
}
