package pin;

/**
 * @Author: Jeremy
 * @Date: 2020/8/31 17:50
 */

import java.util.ArrayList;
import java.util.List;

public class Arrange {
    public static void main(String[] args) {
        Arrange arrange = new Arrange();
        List<Character> data = new ArrayList<>();
        data.add('a');
        data.add('b');
        data.add('c');
        data.add('d');

        //输出A(n,n)的全排列
        for (int i = 1; i <= data.size(); i++)
            arrange.arrangeSelect(data, new ArrayList<>(), i);

        // 组合
        arrange.arrangeSelect(data, new ArrayList<>(), data.size());
    }

    /**
     * 计算A(n,k)
     *
     * @param data
     * @param target
     * @param k
     */
    public <E> void arrangeSelect(List<E> data, List<E> target, int k) {
        if (target.size() == k) {
            for (E i : target)
                System.out.print(i);
            System.out.println();
        }

        List<E> copyData;
        List<E> copyTarget;
        for (int i = 0; i < data.size(); i++) {
            copyData = new ArrayList<>(data);
            copyTarget = new ArrayList<>(target);

            copyTarget.add(copyData.get(i));
            copyData.remove(i);

            arrangeSelect(copyData, copyTarget, k);
        }
    }
}