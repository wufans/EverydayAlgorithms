/**
 * @Author: WuFan
 * @Date: 2019/3/6 9:59
 */

package offer;

import java.util.ArrayList;

/*
* 二叉树中和为某一值的路径
* 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)*/
public class Solution34 {
//    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int
//            target) {
//        backtracking(root, target, new ArrayList<>());
//        return ret;
//    }
//    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
//        if (node == null)
//            return;
//        path.add(node.val);
//        target -= node.val;
//        if (target == 0 && node.left == null && node.right == null)
//        {
//            ret.add(new ArrayList<>(path));
//        } else {
//            backtracking(node.left, target, path);
//            backtracking(node.right, target, path);
//        }
    /*
    * 当前结点访问结束后，递归函数将自动回到它的父结点。因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根结点到父结点的路径。*/
//        path.remove(path.size() - 1); //？？？？？？？？？？
//    }
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        helper(new ArrayList<Integer>(),root,target);
        return res;
    }
    private void helper(ArrayList<Integer> temp, TreeNode root,int target){
        if(root == null){
            return;
        }
        temp.add(root.val);
        ArrayList<Integer> temp_r = new ArrayList<>();
        for(Integer i : temp){
            temp_r.add(i);
        }
        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(temp);
            return;
        }
        if(root.left != null){
            helper(temp,root.left,target);
        }
        if(root.right!= null){
            helper(temp_r,root.right,target);
        }
    }
}
