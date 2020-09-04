package javalearning.insideclass;

/**
 * @Author: Jeremy
 * @Date: 2019/6/6 11:46
 */
class OuterClass {
    public int age = 10;
    public static int height = 180;

    public OuterClass(){
        System.out.println("constructor");
        test();
        System.out.println("constructor");
    }

    public class InnerClass {
        public int innerAge;

        public static final int innerHeight = 10;  // 常量

        public InnerClass(int age) {
            this.innerAge = age;
        }

        public void test() {
            System.out.println("age: " + age);
            System.out.println(this.innerAge);
            System.out.println(OuterClass.this.age);
            OuterClass.this.test();
        }
    }

    public static class InnerStaticClass {
        public int innerStaticAge;

        public InnerStaticClass(int age) {
            this.innerStaticAge = age;
        }

        public void test() {
            System.out.println(this.innerStaticAge);
            System.out.println(height);
            test2();
        }
    }

    public void test() {
        // 外部类不可以直接调用内部类的变量
        // System.out.println(innerAge);
        System.out.println("test");
//        InnerClass innerClass = new InnerClass(12);
//        innerClass.test();
//        System.out.println(innerClass.innerAge);
//        new InnerStaticClass(20).test();
        class LocalInnerClass{

        }
    }

    public void show(){
        final int a = 25;
        int b = 13;
        class Inner{
            int c = 2;
            public void print(){
                System.out.println("访问外部类:" + a);
                System.out.println("访问外部类:" + b);
                // b = 10; // error
                System.out.println("访问内部类:" + c);
            }
        }
        Inner i = new Inner();
        i.print();
    }

    public static void test2() {
        System.out.println("test2");
        //new InnerStaticClass(20).test();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.test();
        OuterClass.test2();

        InnerClass c = outerClass.new InnerClass(10);
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass(10);
        innerClass.test();

        OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass(12);
        innerStaticClass.test();
    }
}

class Test{
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.test();
        OuterClass.test2();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass(10);
        innerClass.test();

        OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass(12);
        innerStaticClass.test();

        outerClass.show();
    }
}