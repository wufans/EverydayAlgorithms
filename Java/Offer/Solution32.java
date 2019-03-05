/**
 * @Author: WuFan
 * @Date: 2019/3/5 20:09
 */

package offer;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

/*
* 从上往下打印二叉树
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。*/
//递归适合深度优先，而这里属于广度优先遍历

//使用队列数据结构来完成广度优先遍历
//类似这种思想的题目，可以考虑根据队列先进先出的特点来做！！！
public class Solution32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }
}
