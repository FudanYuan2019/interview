package javalearning.generic;

/**
 * @Author: Jeremy
 * @Date: 2019/5/21 11:01
 */
public class Circle extends Shape {
    public Circle(Number type){
        super(type);
    }

    public String getInfo(){
        return super.getType().toString();
    }

    public static void main(String[] args){
        Circle circle = new Circle(12);
        System.out.println(circle.getInfo());
    }
}
