/**
 * @Author: WuFan
 * @Date: 2019/3/5 20:55
 */

package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//把二叉树打印成多行
//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
public class Solution32_2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        Queue<TreeNode> save = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        save.add(pRoot);
        while(!save.isEmpty()){
            int count = save.size();   //这一步比较关键！！！！！！！
            ArrayList<Integer> te = new ArrayList();
            while(count>0){
                TreeNode temp = save.poll();
                te.add(temp.val);
                if(temp.left != null){
                    save.add(temp.left);
                }
                if(temp.right != null){
                    save.add(temp.right);
                }
                count--;
            }
            res.add(te);
        }

        return res;
    }

}
