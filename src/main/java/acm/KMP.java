package acm;

/**
 * @Author: Jeremy
 * @Date: 2018/10/7 18:14
 */
public class KMP {

    public static void main(String args[]){
        for (int i : getNext("ababaabab")){
            System.out.print(i + " ");
        }
        //-1 0 0 1 2 3 1 2 3
        System.out.println();
        for (int i : getNextVal("ABCDABD")){
            System.out.print(i+1 + " ");
        }

    }

    public static int[] getNext(String string){
        int[] ret = new int[string.length()];
        ret[0] = -1;
        int k = -1;
        int j = 0;
        while (j < string.length()-1){
            if (k == -1 || string.charAt(j) == string.charAt(k)){
                ret[++j] = ++k;
            } else{
                k = ret[k];
            }
        }

        return ret;
    }

    public static int[] getNextVal(String string){
        int[] ret = new int[string.length()];
        ret[0] = -1;
        int k = -1;
        int j = 0;
        while (j < string.length()-1){
            System.out.printf("j = %d, k = %d\n", j, k);
            if (k == -1 || string.charAt(j) == string.charAt(k)){
                System.out.printf("compare p[%d] and p[%d]\n", j+1, k+1);
                if (string.charAt(++j) == string.charAt(++k)) { // 当两个字符相等时要跳过
                    System.out.printf("p[%d] == p[%d], so next[%d] = next[%d] = %d\n", j, k, j, k, ret[k]);
                    ret[j] = ret[k];
                } else {
                    System.out.printf("p[%d] != p[%d], so next[%d] = %d\n", j, k, j, k);
                    ret[j] = k;
                }
            } else{
                System.out.printf("k != -1 and p[%d] != p[%d]", j, k);
                k = ret[k];
                System.out.printf(", so k = %d\n", k);
            }
            System.out.println();
        }

        return ret;
    }

    public static boolean KMP(String A, String B){
        int[] next = getNext(B);
        int i = 0;
        int j = 0;

        while (i < A.length() && j < B.length()){
            if (j == -1 || A.charAt(i) == B.charAt(j)){
                i++;
                j++;
            } else{
                j = next[j];
            }
        }
        if (j == B.length()){
            return true;
        }
        return false;
    }
}
