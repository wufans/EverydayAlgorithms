/**
 * @Author: WuFan
 * @Date: 2019/3/17 20:13
 */

package offer;
/*
* 平衡二叉树
* 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
* 平衡二叉树左右子树高度差不超过1*/
public class Solution55_2 {
    //Mysolution
    public boolean IsBalanced_Solution(TreeNode root) {
        return root == null?true:Math.abs(getDepth(root.right)-getDepth(root.left))<=1;
    }
    public int getDepth(TreeNode node){
        return node==null?0:Math.max(getDepth(node.left)+1,getDepth(node.right)+1);
    }

    //另一个Solution
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution2(TreeNode root) {
        height(root);
        return isBalanced;
    }
    private int height(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}
