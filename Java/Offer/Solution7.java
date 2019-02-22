/**
 * @Author: WuFan
 * @Date: 2019/1/4 23:18
 */
//重建二叉树
package offer;

import java.util.HashMap;
import java.util.Map;

/*
* 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的
* 前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列
* {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉
* 树并返回。*/


/*主要是前序遍历的第一个数一定是根节点，因此，可以根据前序遍历的第一个节点，再根据中序遍历序列得到左右子树。*/
public class Solution7 {
    private Map<Integer, Integer> indexForInOrders = new HashMap<>()
            ;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);

    }

private TreeNode reConstructBinaryTree(int[] pre, int preL, int
            preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize
                + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
