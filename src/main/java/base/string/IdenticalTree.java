package base.string;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 * @Author: Jeremy
 * @Date: 2018/10/19 15:33
 */


/**
 * 解决思路：
 * 1. 二叉树序列化+StringMatch——O(M+N)
 * 2. 两二叉树节点比较——O(M*N)
 */
public class IdenticalTree {
    public static void main(String args[]){
        for (int i : getNext("ababaabab")){
            System.out.print(i + " ");
        }
        //-1 0 0 1 2 3 1 2 3
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
        System.out.print("先序遍历（非递归）：" + preOrderTraverseTree(root));

        TreeNode B = new TreeNode(1);

        IdenticalTree identicalTree = new IdenticalTree();
        boolean res = identicalTree.chkIdentical(root, B);
        System.out.println(res);
    }

    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        String str1 = preOrderTraverseTree(A);
        String str2 = preOrderTraverseTree(B);
        return KMP(str1, str2);
    }

    /**
     * 非递归实现先序遍历
     * @param A
     * @return
     */
    public static String preOrderTraverseTree(TreeNode A){
        if (A == null){
            return "#!";
        }

        StringBuffer serial = new StringBuffer();
        serial.append(String.valueOf(A.val) + "!");
        serial.append(preOrderTraverseTree(A.left));
        serial.append(preOrderTraverseTree(A.right));
        return serial.toString();
    }

    /**
     * 求子字符串的next数组
     * @param A
     * @return int[]
     */
    public static int[] getNext(String A){
        char[] P = A.toCharArray();
        int[] next = new int[A.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < P.length - 1){
            if (k == -1 || P[k] == P[j]){
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }

    /**
     * StringMatch
     * @return
     */
    public static boolean KMP(String A, String B){
        char[] S = A.toCharArray();
        char[] P = B.toCharArray();
        int lenS = S.length;
        int lenP = P.length;
        int[] next = getNext(B);
        int i = 0;
        int j = 0;
        while (i<lenS && j<lenP){
            if (j == -1 || S[i] == P[j]){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == lenP){
            return true;
        }
        return false;
    }
}
