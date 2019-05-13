package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wufan77
 * @date 2019/5/13 16:30
 */

/*
* Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
*
* 二叉树的中序遍历*/
public class Solution94 {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    //非递归版本
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        while(true){
            while(root!= null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null){
                root = temp.right;
            }else{
                root = null;
            }

        }
        return res;
    }

    //递归版本
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        if(root == null){
            return res;
        }
        inorderTraversal_recursive(root.left);
        res.add(root.val);
        inorderTraversal_recursive(root.right);
        return res;
    }
}
