package base.binaryTree;

/**
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * <p>
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 *
 * @Author: Jeremy
 * @Date: 2019/6/6 16:26
 * <p>
 * (平衡二叉树定义：（1）空树是平衡二叉树；（2）左右子树高度差不超过1；)
 */

/**
 * 解题思路：二叉树的遍历。二叉树很多题目都是用递归遍历的代码改写的。
 * 1. 先判断左子树是不是AVL，不是直接返回false；
 * 2. 如果左子树是AVL，再去遍历右子树。遍历的同时收集两个信息：最深到哪一层，和是否是AVL。
 */
public class CheckBalance {
    public boolean check(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return check(root.left) && check(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
