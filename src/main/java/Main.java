import base.binaryTree.TreeNode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class Foo {
    public static void main(String sgf[]) {

        StringBuffer a = new StringBuffer("A");

        StringBuffer b = new StringBuffer("B");

        operate(a, b);

        System.out.println(a + "." + b);

        int count = 0;
        int num = 0;
        for (int i = 0; i <= 100; i++) {
            num = num + i;
            count = count++;
        }
        System.out.println(count);
        System.out.println(num * count);

        double d1 = -0.5;
        System.out.println("Ceil d1=" + Math.ceil(d1));
        System.out.println("floor d1=" + Math.floor(d1));
        URL u;
        try {

            u = new URL("http://www.123.com");
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        char ch = '中';
        System.out.println(ch);

        int[] arr = {1, 2, 3};
    }

    static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}

//public class Main {
//    public static void single() {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//
//    public static void multiple() {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(n);
//        int ans = 0, x;
//        for (int i = 0; i < n; i++) {
//            x = sc.nextInt();
//            ans += x;
//        }
//        System.out.println(ans);
//    }
//
//    public static void question1() {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int ans = 0, x;
//        for (int i = 0; i < n; i++) {
//            x = sc.nextInt();
//            a[i] = x;
//        }
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int score = a[i] + a[j] + i - j;
//                if (score > ans) {
//                    ans = score;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//
//    public static void question2() {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        System.out.println(n + " " + m);
//        int[][] a = new int[n][m];
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
////        for (int i = 0; i < n - 1; i++) {
////            for (int j = i + 1; j < n; j++) {
////                int score = a[i] + a[j] + i - j;
////                if (score > ans){
////                    ans = score;
////                }
////            }
////        }
//        System.out.println(ans);
//    }
//
//    public static void main(String[] args) {
//        Foo f = new Foo();
//
//        Scanner sc = new Scanner(System.in);
//        String string = sc.nextLine();
//        StringBuilder ans = new StringBuilder();
//        Stack<Character> stack = new Stack<>();
//        for (int i = string.length() - 1; i >= 0; i--) {
//            Character ch = string.charAt(i);
//            if (ch == '%') {
//                int mul = string.charAt(--i) - 48;
//                Character top = stack.peek();
//                StringBuilder sb = new StringBuilder();
//                while (top != '#' && !stack.isEmpty()) {
//                    sb.append(stack.pop());
//                    top = stack.peek();
//                }
//                if (top == '#') {
//                    stack.pop();
//                }
//                StringBuilder temp = new StringBuilder();
//                for (int j = 0; j < mul; j++) {
//                    temp.insert(0, sb.toString());
//                }
//                if (stack.isEmpty()) {
//                    ans.insert(0, temp.toString());
//                } else {
//                    for (int j = temp.length() - 1; j >= 0; j--) {
//                        stack.push(temp.charAt(j));
//                    }
//                }
//                continue;
//            }
//            stack.push(ch);
//        }
//        System.out.println(ans.toString());
//    }
//}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //容量
            int V = sc.nextInt();
            //种类
            int N = sc.nextInt();
            //数量
            ArrayList<Integer> n = new ArrayList<>();
            //体积
            ArrayList<Integer> w = new ArrayList<>();
            //价值
            ArrayList<Integer> v = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                //数量
                int a = sc.nextInt();
                //体积
                int b = sc.nextInt();
                //价值
                int c = sc.nextInt();
                n.add(a);
                w.add(b);
                v.add(c);
            }

            int[][] dp = new int[N][1 + V];
            for (int i = 0; i < 1 + V; i++) {
                dp[0][i] = i >= w.get(0) ? v.get(0) : 0;
            }
            for (int i = 0; i < N; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < 1 + V; j++) {
                    dp[i][j] = 0;
                    for (int k = 0; k <= n.get(i); k++) {
                        if (j - k * w.get(i) >= 0) {
                            int cur = dp[i - 1][j - k * w.get(i)] + v.get(i) * k;
                            if (dp[i][j] < cur) {
                                dp[i][j] = cur;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            System.out.println(dp[N - 1][V]);
        }
    }
}


//class A {
//}
//
//class B extends A {
//}
//
//class C extends A {
//}
//
//class D extends B {
//    public static void main(String[] args) {
//        A obj = new D();
//
//        System.out.println(obj instanceof B);
//
//        System.out.println(obj instanceof C);
//
//        System.out.println(obj instanceof D);
//
//        System.out.println(obj instanceof A);
//
//    }
//}

class A {
    public A() {
        System.out.println("class A");
    }

    public A(int a){
        System.out.println(a);
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("class A static");
    }
}

class B extends A {
    public B() {
        System.out.println("class B");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("class B static");
    }

    public static void main(String[] args) {
        new B();

        Boolean flag = false;
        if (flag = true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        int[] x = new int[10];
        System.out.println(Arrays.toString(x));

        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i01 == i02);
        System.out.println(i01 == i03);
        System.out.println(i01 == i04);
        System.out.println(i02 == i04);
        System.out.println(i03 == i04);

        long test = 012;
        float f = -412;
        double d = 0x12345678;
        byte b = 127;

        B b1 = new B();
        B b2 = b1;
        System.out.println(b1== b2);
    }
}

class NameList {
    private List names = new ArrayList();

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + "");
        }
    }

    public static void main(String[] args) {
        final NameList sl = new NameList();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            }.start();
        }
    }
}

class MyThead extends Thread{
    public static void main(String[] args) {
        MyThead t=new MyThead();
        MyThead s=new MyThead();
        t.start();
        System.out.println("one.");
        s.start();
        System.out.println("two.");
    }
    public void run() {
        System.out.println("Thread");
    }
}

class Test{
    static int x=10;
    static {x+=5;}
    public static void main(String[] args) //4
    {
        System.out.println("x="+x);
        String str = "";
        System.out.println(Arrays.toString(str.split(",")));
        System.out.println(str.split(",")[0]);
        System.out.print(str.split(",").length);
    }
    static{x/=3;}


}

class Car extends Vehicle
{
    public static void main (String[] args)
    {
        new  Car(). run();
    }

    private final void run()
    {
        System. out. println ("Car");
    }
}
class Vehicle
{
    private final void run()
    {
        System. out. println("Vehicle");
    }
}


class ClassA {
    static int count = 0;
    static {
        count++;
        System.out.println("A");
    }
    public ClassA() {
        System.out.println("B");
    }
}

class ClassB {
    static {
        ClassA t2;
        System.out.println("C");
    }
    public static void main(String[] args) {
        Class c1;
        Class c2;
        Class c3;
        try {
            c1 = ClassA.class;
            c2 = Class.forName("ClassA");
            ClassA a = new ClassA();
            c3 = a.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        if (c2 == c1&& c1 == c3) {
            System.out.println("D");
        } else {
            System.out.println("E");
        }
        System.out.println(ClassA.count);

        int i = 0;
        do{
            System.out.println(i);
        } while (i++ < 2);

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int count = 1;
    public int max = 1;
    public TreeNode preNode = null;
    public HashMap<Integer, Integer> countMap = new HashMap<>();
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left, list);
        if(preNode != null){
            if(preNode.val == root.val){
                count++;
            } else{
                count = 1;
            }
        }
        if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        } else if(count == max){
            list.add(root.val);
        }
        preNode = root;
        inOrder(root.right, list);
    }
}