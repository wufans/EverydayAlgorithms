package leetcode;

/**
 * @Author: wufan
 * @Date: 2019/8/8 10:52
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution102 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        nodes.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!nodes.isEmpty()){
            List<TreeNode> newNodes = new ArrayList<>();
            List<Integer> tempResult = new ArrayList<>();
            for(TreeNode node:nodes){
                tempResult.add(node.val);
                if(node.left != null){
                    newNodes.add(node.left);
                }
                if(node.right != null){
                    newNodes.add(node.right);
                }
            }
            nodes = newNodes;
            result.add(tempResult);
        }
        return result;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
