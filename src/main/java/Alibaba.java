import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/3/23 18:50
 */
public class Alibaba {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int n = in.nextInt();
//            int res = 0;
//            for (int i = 0; i < n; i++) {
//                res += c(n - 1, i);
//            }
//            System.out.println((c(n, 1) * res) % 1000000007);
//        }
//        new Alibaba().method(null);
    }

    public static int c(int n, int m) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < m; i++) {
            a = a * n;
            n--;
        }
        for (; m > 0; m--) {
            b = b * m;
        }
        return a / b;
    }
    public void method(String s) {
        System.out.println(s);
    }
    public void method(Object o) {

    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        for (int i = 0; i < n; i++){
//            String line = sc.next();
//            for (int j = 0; j < m; j++){
//                char tag = line.charAt(j);
//                System.out.println(tag);
//            }
//        }
//    }
}


class T{

}
class X extends T{

}
class Y extends X {

}


class Test01 {
    public static void main(String args[]){
        Other other = new Other();
        new Test01().method(other);
        System.out.println(other.o);

    }

    public void method(final Other other){
        other.o++;
    }
}

class Other {
    public int o;
}