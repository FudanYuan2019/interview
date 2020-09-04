package base.binaryTree;

/**
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。
 * 对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 *
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 *
 * @Author: Jeremy
 * @Date: 2019/6/10 10:57
 */

/**
 * 解题思路：
 * 最大距离只可能有三种情况：
 * （1）root左子树的最大距离；
 * （2）root右子树的最大距离；
 * （3）root左子树上离root左孩子最远结点的距离，加上root自身；再加上root右子树上离root右孩子最远结点的距离
 * 三个中，最大的即为所求。
 */
public class LongestDistance {
    public int longest = 0;
    public int findLongest(TreeNode root) {
        findDist(root);
        return longest;
    }

    public int findDist(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findDist(root.left);
        int right = findDist(root.right);
        longest = Math.max(left + right + 1, longest);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left_1 = new TreeNode(2);
        TreeNode right_1 = new TreeNode(3);
        TreeNode left_21 = new TreeNode(4);
        TreeNode left_22 = new TreeNode(5);
        TreeNode right_22 = new TreeNode(6);

        root.left = left_1;
        root.right = right_1;

        left_1.left = left_21;

        right_1.left = left_22;
        right_1.right = right_22;

        LongestDistance longestDistance = new LongestDistance();
        int res = longestDistance.findLongest(root);
        System.out.println(res);
    }
}
