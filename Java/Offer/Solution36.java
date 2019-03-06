/**
 * @Author: WuFan
 * @Date: 2019/3/6 20:57
 */

package offer;

import java.util.ArrayList;
import java.util.List;

/*
* 二叉搜索树与双向链表
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。*/
public class Solution36 {
    //我的方法太粗暴了吧。。
//    private ArrayList<TreeNode> forw = new ArrayList<>();
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
//            return pRootOfTree;
//        helper(pRootOfTree);
//        TreeNode[] res = forw.toArray(new TreeNode[forw.size()]);
//        if(res.length == 1){
//            return res[0];
//        }else{
//            res[0].right = res[1];
//            res[0].left = null;
//            res[forw.size()-1].right = null;
//            res[forw.size()-1].left = res[forw.size()-2];
//            for (int i = 1; i < forw.size()-1; i++) {
//                res[i].right = res[i+1];
//                res[i].left = res[i-1];
//            }
//        }
//        return res[0];
//
//
//    }
//    private void helper(TreeNode t){
//        if(t == null){
//            return;
//        }
//        helper(t.left);
//        forw.add(t);
//        helper(t.right);
//    }

    //别人的解法
    private TreeNode pre = null; //表示递归中的前一个节点
    private TreeNode head = null; //表示最终返回的节点，也就是值最小的那个节点
    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
}
