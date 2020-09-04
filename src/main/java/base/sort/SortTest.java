package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/11 12:22
 */
public class SortTest {
    public static void main(String args[]){
        BubbleSort bubbleSort = new BubbleSort();
        int[] A = new int[]{2,4,3,5,1,3,6,0};
//        int[] B = bubbleSort.bubbleSort(A, A.length);
//        for (int i : B){
//            System.out.print(i + " ");
//        }
//        System.out.println();

//        SelectSort selectSort = new SelectSort();
//        int[] C = selectSort.selectionSort(A, A.length);
//        for (int i : C){
//            System.out.print(i + " ");
//        }
//        System.out.println();

        InsertSort insertSort = new InsertSort();
        int[] D = insertSort.insertionSort(A, A.length);
        for (int i : D){
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
