package javalearning.object;

/**
 * @Author: Jeremy
 * @Date: 2019/5/22 11:55
 */
public class InstanceInitTest {

    static {
        a = 6;
    }

    private static int a = 9;

    public InstanceInitTest(){
        InstanceInitTest.a = 10;
    }

    public static void main(String[] args){
        System.out.println(InstanceInitTest.a);
        InstanceInitTest test = new InstanceInitTest();
        System.out.println(InstanceInitTest.a);
    }
}
