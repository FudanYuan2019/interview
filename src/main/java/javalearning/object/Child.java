package javalearning.object;

/**
 * @Author: Jeremy
 * @Date: 2019/5/30 13:54
 */
class Person{
    private String name = "Person";
    int age=0;
}
public class Child extends Person{
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        //System.out.println(p.name);

        String s = "hell0";
        String t = "hell0";
        System.out.println(s == t);
    }
}