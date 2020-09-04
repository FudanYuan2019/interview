package base.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展开。
 * 此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；
 * 突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。
 * 如果每次都从下边向上⽅ 对折，对折N次。
 * 请从上到下计算出所有折痕的⽅向。
 * <p>
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 * <p>
 * 测试样例：
 * 1
 * 返回：["down"]
 *
 * @Author: Jeremy
 * @Date: 2019/6/8 15:45
 */

/**
 * //
 */
public class FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        core(n, true, list);
        String[] strings = new String[list.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }

    public void core(int n, boolean down, List<String> list) {
        if (n == 0) {
            return;
        }
        core(n - 1, true, list);
        list.add(down ? "down" : "up");
        core(n - 1, false, list);
    }

    public static void main(String[] args) {
        FoldPaper foldPaper = new FoldPaper();
        String[] res = foldPaper.foldPaper(3);
        System.out.println(Arrays.toString(res));
    }
}
