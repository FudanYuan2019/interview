package javalearning.interfaces;

/**
 * @Author: Jeremy
 * @Date: 2019/5/28 10:22
 */
public interface InterfaceTest {
    String a = "";
}

class Implement implements InterfaceTest{
    public static void main(String[] args){
        Implement implement = new Implement();
        implement.hashCode();
    }
}