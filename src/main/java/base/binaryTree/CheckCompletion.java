package base.binaryTree;

import base.combination.Stack;

import java.util.LinkedList;

/**
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * <p>
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 *
 * @Author: Jeremy
 * @Date: 2019/6/6 16:37
 */
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(cur);
        boolean flag = false;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            // 如果左节点为空，右节点不为空，则直接返回false
            if (cur.right != null && cur.left == null) {
                return false;
            }
            // 如果左节点不为空，但上一节点的右节点为空（flag=true），则返回false
            if (cur.left != null) {
                if (flag){
                    return false;
                }
                queue.add(cur.left);
            }
            // 右节点不为空
            if (cur.right != null) {
                flag = false;
                queue.add(cur.right);
            } else { // 右节点为空，flag=true
                flag = true;
            }
        }
        return true;
    }
}
