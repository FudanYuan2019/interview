package base.binaryTree;

/**
 * 有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.
 *
 * 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 *
 * @Author: Jeremy
 * @Date: 2019/6/10 11:26
 */

/**
 * 解题思路：
 * 以node结点为头的二叉树最大的搜索二叉子树只有两种情况：
 * 1. 来自node左子树上的最大搜索二叉子树是以node左孩子为头的，
 * 并且来自node右子树的最大搜索二叉子树是以node右孩子为头的.
 * node左子树上的最大搜索二叉子树的最大值小于node的节点值，
 * node右子树的最大搜索二叉子树的最小值大于node的节点值，那么以结点node为头的整个二叉树都是搜索二叉树。
 * 2. 如果不满足第一种情况，说明以结点node为头的树整体不能连成搜索二叉树。
 * 这种情况下，以node为头的树上的最大搜索二叉子树
 * 是来自node的左子树上的最大搜索二叉子树和来自node的右子树的最大搜索二叉子树之间，节点数较多的那个。
 *
 * 具体操作：
 * 1. 整体过程为二叉树的后序遍历；
 * 2. 遍历到当前结点记作cur时，先遍历cur的左子树并收集4个信息：
 * 分别是左子树上，最大搜索二叉树的头结点、结点数、树上最大值和树上最小值。
 * 再遍历cur的右子树，收集以上四个信息。
 * 3.根据步骤2所收集的信息，判断是否满足第一种情况：是否以cur为头的子树，整体都是搜索二叉树，如果满足，就返回cur。
 * 如果满足第二种情况，就返回左子树和右子树各自最大搜索二叉树中，节点数较多的头结点。
 */

public class MaxSubtree {
    public TreeNode getMax(TreeNode root) {
        TreeNode res = getMaxSearchTree(root).head;
        return res;
    }

    private Four getMaxSearchTree(TreeNode root) {
        if (root == null) {
            return new Four(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Four left = getMaxSearchTree(root.left);
        Four right = getMaxSearchTree(root.right);

        if (left.maxValue < root.val && right.minValue > root.val
                && left.head == root.left && right.head == root.right) {
            //更新最大搜索二叉树的头结点、结点数、树上最大值和树上最小值；
            return new Four(root, left.nodes + right.nodes + 1,
                    Math.max(right.maxValue, root.val), Math.min(left.minValue, root.val));
        }
        if (left.nodes > right.nodes) {
            return new Four(left.head, left.nodes,
                    Math.max(right.maxValue, root.val), Math.min(left.minValue, root.val));
        }
        //等号必须有。不然用例“{6,5,#,4,#,1,#,2,3,#,#,#,#}”报错；
        if (left.nodes <= right.nodes) {
            return new Four(right.head, right.nodes,
                    Math.max(right.maxValue, root.val), Math.min(left.minValue, root.val));
        }
        //递归到叶子结点的时候
        return new Four(root, 1,
                root.val, root.val);
    }
}

/**
 * 储存四个信息的数据结构
 */
class Four{

    public TreeNode head;
    public int nodes;
    public int maxValue;
    public int minValue;

    public Four(TreeNode head, int nodes, int maxValue, int minValue){
        this.head = head;
        this.nodes = nodes;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}