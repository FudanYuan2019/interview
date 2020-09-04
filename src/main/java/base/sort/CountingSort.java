package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/12 20:47
 */
public class CountingSort {
    public static void main(String args[]){
        CountingSort countingSort = new CountingSort();
        int[] A = countingSort.countingSort(new int[]{1,2,3,5,2,3}, 6);
        for (int a : A){
            System.out.print(a + " ");
        }
        System.out.println();
    }
    public int[] countingSort(int[] arr, int n) {
        // write code here
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int len = max - min + 1;
        int[] countArray = new int[len];
        for (int i=0; i<n; i++){
            int val = arr[i];
            countArray[val-min]++;
        }

        int index = 0;
        for (int i=0; i<countArray.length; i++){
            while (countArray[i]-- > 0){
                arr[index++] = i + min;
            }
        }
        return arr;
    }
}
