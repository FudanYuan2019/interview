package base.array;

import java.util.Arrays;

/**
 * 写一个算法，可以将一个二维数组顺时针旋转90度
 * (x, y) -> (y, n - x - 1)
 *
 * @Author: Jeremy
 * @Date: 2019/11/4 12:13
 */
public class RotateMatrix {
    /**
     * 空间复杂度O(1), 时间复杂度O(N)
     *
     * @param array
     * @return
     */
    public static int[][] rotate1(int[][] array) {
        int[][] arr = array.clone();
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                count++;
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - j][i];
                arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
                arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
                arr[j][n - 1 - i] = temp;
            }
        }
        System.out.println(count);
        return arr;
    }

    /**
     * 空间复杂度O(N), 时间复杂度O(N*M)
     *
     * @param array
     * @return
     */
    public static int[][] rotate2(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int count = 0;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count++;
                result[i][j] = array[n - j - 1][i];
            }
        }
        System.out.println(count);
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = i * n + j + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        int[][] array1 = rotate1(array);
        for (int i = 0; i < array1.length; i++) {
            System.out.println(Arrays.toString(array1[i]));
        }
        System.out.println();

        int[][] array2 = rotate2(array);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(Arrays.toString(array2[i]));
        }
        System.out.println();
    }
}
