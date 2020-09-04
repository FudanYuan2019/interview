package base.array;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author: Jeremy
 * @Date: 2019/6/12 12:39
 */
public class FindNumInArray {
    public boolean find(int target, int [][] array) {
        int i = 0;
        int j = array[0].length - 1;
        while(i >= 0 && j >= 0 && i < array.length && j < array[0].length){
            int cur = array[i][j];
            if (target > cur){
                i++;
            } else if (target < cur){
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int target = 3;
        int[][] array = new int[3][];
        array[0] = new int[]{1,3,4};
        array[1] = new int[]{2,4,5};
        array[2] = new int[]{4,5,6};

        FindNumInArray findNumInArray = new FindNumInArray();
        System.out.println(findNumInArray.find(target, array));
    }
}
