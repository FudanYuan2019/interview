package base.binarysearch;

import java.util.LinkedList;

/**
 * @Author: Jeremy
 * @Date: 2019/6/22 20:30
 */

public class BinarySearchTree {
    public TreeNode parent = null;

    /**
     * 二叉查找树查找元素
     *
     * @param root 二叉查找树的根节点
     * @param val  需要查找的目标值
     * @return
     */
    public TreeNode search(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            // 记录当前节点的父节点
            this.parent = root;
            return search(root.left, val);
        } else if (val > root.val) {
            // 记录当前节点的父节点
            this.parent = root;
            return search(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 增加新节点
     *
     * @param root 二叉查找树的根节点
     * @param val  需要增加的目标值
     * @return
     */
    public TreeNode insert(TreeNode root, int val) {
        // 由于性质4，因此插入之前先判断该值是否存在
        TreeNode node = search(root, val);
        if (node == null) {
            TreeNode newNode = new TreeNode(val);
            if (parent == null) {
                root = newNode;
            } else if (val < parent.val) {
                parent.left = newNode;
            } else if (val > parent.val) {
                parent.right = newNode;
            }
        }
        // 返回根节点
        return root;
    }

    /**
     * 删除节点
     *
     * @param root 二叉查找树的根节点
     * @param val  需要删除的目标值
     * @return
     */
    public TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        // 首先搜索该节点，如果不存在直接返回false
        TreeNode o = search(root, val);
        if (o == null) {
            return root;
        }

        if (o.left == null && o.right == null) {
            // 情况1：如果该节点为叶子节点，直接删除即可
            // o为左节点
            if (parent.left == o) {
                parent.left = null;
            } else {  // o为右节点
                parent.right = null;
            }
        } else if (o.right == null) {
            // 情况2-1：如果该节点只有左子树
            // o为左节点
            if (parent.left == o) {
                parent.left = o.left;
            } else {  // o为右节点
                parent.right = o.left;
            }
        } else if (o.left == null) {
            // 情况2-2：如果该节点只有右子树
            // o为左节点
            if (parent.left == o) {
                parent.left = o.right;
            } else {  // o为右节点
                parent.right = o.right;
            }
        } else {
            // 情况3：该节点既有左子树，又有右子树
            TreeNode q = o;
            TreeNode s = o.left;
            while (s.right != null) {
                q = s;
                s = s.right;
            } // 转左，然后向右到尽头
            // s指向被删节点的“前驱”
            o.val = s.val;
            if (q != o) {
                // 重接q的右子树
                q.right = s.left;
            } else {
                // 重接q的左子树
                q.left = s.left;
            }
        }
        return root;
    }

    /**
     * 获取节点个数
     *
     * @param root
     * @return
     */
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + 1 + size(root.right);
    }

    /**
     * 获取二叉查找树的高度
     *
     * @param root
     * @return
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    /**
     * 获取最大值
     * @param root
     * @return
     */
    public int max(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.right == null){
            return root.val;
        }

        return max(root.right);
    }

    /**
     * 获取最小值
     * @param root
     * @return
     */
    public int min(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null){
            return root.val;
        }

        return min(root.left);
    }

    /**
     * 中序遍历二叉树，非递归
     *
     * @param root
     */
    public void inOrderTraverseNoRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            // 一直循环到二叉树最左端的叶子结点（currentNode是null）
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(14);
        TreeNode g = new TreeNode(4);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(13);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.right = f;

        e.left = g;
        e.right = h;

        f.left = i;

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // 中序遍历
        binarySearchTree.inOrderTraverseNoRecursion(a);

        // 查询节点
        TreeNode node = binarySearchTree.search(a, 14);
        System.out.println(node.val);

        // 插入节点
        TreeNode root = binarySearchTree.insert(a, 9);
        System.out.println(c.left.val);
        // 中序遍历
        binarySearchTree.inOrderTraverseNoRecursion(root);

        // 删除节点
        root = binarySearchTree.delete(root, 8);
        binarySearchTree.inOrderTraverseNoRecursion(root);

        // 获取节点个数
        int size = binarySearchTree.size(root);
        System.out.println(size);

        // 获取树高度
        int height = binarySearchTree.height(root);
        System.out.println(height);

        // 获取最小值
        int min = binarySearchTree.min(root);
        System.out.println(min);

        // 获取最大值
        int max = binarySearchTree.max(root);
        System.out.println(max);

        // 插入节点
        root = binarySearchTree.insert(a, 12);
        System.out.println(i.left.val);
        System.out.println(binarySearchTree.parent.val);
        // 中序遍历
        binarySearchTree.inOrderTraverseNoRecursion(root);
        System.out.println(binarySearchTree.height(c.left) - binarySearchTree.height(c.right));
    }
}