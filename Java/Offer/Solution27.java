/**
 * @Author: WuFan
 * @Date: 2019/3/4 10:52
 */

package offer;
/*
* 二叉树的镜像操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5*/
public class Solution27 {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }if(root.left != null || root.right != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
