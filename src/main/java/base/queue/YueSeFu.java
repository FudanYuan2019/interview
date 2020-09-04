package base.queue;

/**
 * @Author: Jeremy
 * @Date: 2020/1/25 10:53
 */
public class YueSeFu {
    public int yuesefu(int sum, int value, int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1) {
            return (sum + value - 1) % sum;
        } else {
            return (yuesefu(sum - 1, value, n - 1) + value) % sum;
        }
    }

    public int core(int sum, int value){
        int res = 0;
        for (int i = 2; i <= sum; i++){
            res = (res + value) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new YueSeFu().yuesefu(10, 4, i));
        }

        System.out.println();
        System.out.println(new YueSeFu().yuesefu(10, 4, 10));

        System.out.println();
        System.out.println(new YueSeFu().yuesefu(5, 3, 5));
        System.out.println(new YueSeFu().core(5, 3));


        System.out.println(new YueSeFu().core(501, 1));
    }
}

/**
 * 1 2 3 4 5
 * 1 2  4 5 -> 3
 * 2 4 5 -> 1
 * 2 4 -> 5
 */