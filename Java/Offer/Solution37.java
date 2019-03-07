/**
 * @Author: WuFan
 * @Date: 2019/3/6 21:34
 */

package offer;

//这道理需要补充后序遍历和层序遍历的解法。
/*
* 序列化二叉树
* 请实现两个函数，分别用来序列化和反序列化二叉树
*
* 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。

    序列化可以基于 先序、中序、后序、按层 的二叉树遍历方式来进行修改。原理都是一样的（即遍历顺序不同而已，对每个结点的处理都是一样的），
    序列化的结果是一个字符串，序列化时通过  某种符号表示空节点（#），以 ！或者空格 表示一个结点值的结束（value!）。
* */
public class Solution37 {
    //前序遍历
//为什么用前序遍历？因为方便反序列化
    //后序遍历可以通过逆向地前序遍历得到
    /*
    * 仅根据（带空指针的）中序遍历，是不能重建二叉树的。比如，上面这棵树的中序遍历为 #2#1#3#4#。事实上可以证明，任何一棵二叉树的中序遍历结果，都会是空指针与树中结点交替出现的形式，所以空指针没有提供任何额外的信息
    *
    * 一棵二叉树能够被重建，如果满足下面三个条件之一：　　　　
    * a1. 已知先序遍历；或　　　　
    * a2. 已知后序遍历；或　　　　
    * a3. 已知层序遍历；　　
    *
    * 且满足下面三个条件之一：　　　　
    * b1. 前面已知的那种遍历包含了空指针；或　　　　
    * b2. 已知中序遍历，且树中不含重复元素；或　　　　
    * b3. 树是二叉搜索树，且不含重复元素。

*/
    private static String deserializeStr;
    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }
    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }


    private static TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.
                substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring
                (index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

    public static void main(String[] args) {
        String s= "3 9 # # 20 15 # # 7 # #";
        deserializeStr = s;
        TreeNode t = Deserialize();
        System.out.println(t.val+" "+t.right.left.val+" "+t.right.right.val);

    }

}
