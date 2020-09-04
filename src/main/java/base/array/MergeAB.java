package base.array;

/**
 * @Author: Jeremy
 * @Date: 2018/10/18 21:00
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 */
public class MergeAB {
    public static void main(String args[]){
        MergeAB mergeAB = new MergeAB();
        int[] A = new int[]{7,8,9,0,0,0};
        int[] B = new int[]{2,3,6};
        int[] res = mergeAB.mergeAB(A, B, 3, 3);
        for (int a : res){
            System.out.print(a + " ");
        }
        System.out.println();
    }
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        // write code here
        int lenA = A.length;
        int i = m - 1;
        int j = n - 1;
        int counter = 1;
        while (i >= 0 && j >= 0){
            if (B[i] >= A[j]){
                A[lenA-counter] = B[i];
                i--;
            } else {
                A[lenA-counter] = A[j];
                j--;
            }
            counter++;
        }
        while (i >= 0){
            A[i] = B[i--];
        }
        return A;
    }
}