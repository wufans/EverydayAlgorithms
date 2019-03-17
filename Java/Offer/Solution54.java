/**
 * @Author: WuFan
 * @Date: 2019/3/17 15:19
 */

package offer;


import java.util.Stack;

/*
* 二叉查找树的第 K 个结点
* 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。*/
public class Solution54 {

    //用递归的方法：
//    TreeNode res;
//    int count = 1;
//    TreeNode KthNode(TreeNode pRoot, int k) {
//        inOrder(pRoot,k);
//        return res;
//    }
//
//    private void inOrder(TreeNode pRoot, int k) {
//        if(pRoot==null)
//            return;
//        inOrder(pRoot.left,k);
//        if(count == k){
//            res = pRoot;
//            count++;
//        }
//        else
//            count++;
//        inOrder(pRoot.right,k);
//    }


    //用非递归的方法
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k <1){
            return null;
        }
        Stack<TreeNode> temp = new Stack<>();
        int count = 1;
        temp.push(pRoot);
        while(!temp.isEmpty()){
            if(pRoot!=null && pRoot.left!=null){
                temp.push(pRoot.left);
                pRoot = pRoot.left;
            }else{
                //弹出栈顶元素。
                pRoot = temp.pop();
                System.out.println(pRoot.val+"出栈");
                if(count++==k){
                    return pRoot;
                }
                if(pRoot!=null && pRoot.right!=null){
                    temp.push(pRoot.right);
                    pRoot = pRoot.right;
                }else{
                    pRoot = null;
                }
            }
        }
        return pRoot;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution54 test = new Solution54();
        test.KthNode(root,4);
    }


}
