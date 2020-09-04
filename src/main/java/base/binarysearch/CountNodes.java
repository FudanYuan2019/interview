package base.binarysearch;

/**
 * @Author: Jeremy
 * @Date: 2019/6/1 16:58
 */

public class CountNodes {

    public int travel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = travel(root.left) + travel(root.right) + 1;
        return count;
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode p = root;
        // 计算其高度
        int height = 0;
        while (p != null) {
            p = p.left;
            height++;
        }

        int rightHeight = 1;
        p = root.right;
        while (p != null) {
            p = p.right;
            rightHeight += 1;
        }

        int count = 0;
        // 如果右子树的高度小于二叉树的高度，则代表右子树为满二叉树
        if (rightHeight < height) {
            count += Math.pow(2, rightHeight - 1);
            // 然后再加上左子树的个数
            count += travel(root.left);
        } else { // 如果右子树的高度等于二叉树的高度，则代表左子树为满二叉树
            count += Math.pow(2, height - 1);
            count += travel(root.right);
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;

        CountNodes countNodes = new CountNodes();
        int count = countNodes.count(a);
        System.out.println(count);

    }
}
