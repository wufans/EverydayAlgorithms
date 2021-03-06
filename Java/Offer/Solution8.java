/**
 * @Author: WuFan
 * @Date: 2019/1/9 20:37
 */

/*
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。*/

//如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
//否则，向上找第一个左链接指向的树包含该节点的祖先节点。
package offer;

public class Solution8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while(node.left!=null){
                node=node.left;
            }
            return node;
        }else{
            while(pNode.next!=null){
                TreeLinkNode parent = pNode.next;
                if(parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
    private Map<Integer, Integer> indexForInOrders = new HashMap<>()
; 
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
        indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
} 
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize  + 1, preR, inL + leftTreeSize + 1);
        return root;
}
}
