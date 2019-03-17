/**
 * @Author: WuFan
 * @Date: 2019/3/17 20:06
 */

package offer;
/*
* 二叉树的深度
* 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。*/
public class Solution55 {
    private int res = 0;
    public int TreeDepth(TreeNode root) {
        findDepth(root,0);
        return res;
    }
    public void findDepth(TreeNode node,int count){
        if(node == null){
            res = count>res?count:res;
        }else{
            findDepth(node.left,count+1);
            findDepth(node.right,count+1);
        }

    }
    //回溯的方法2
    public int TreeDepth2(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left),
                TreeDepth(root.right));
    }
}
