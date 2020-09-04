package javalearning.generic;

/**
 * @Author: Jeremy
 * @Date: 2019/5/21 10:52
 */
public class Rect extends Shape<Long> {
    private final int b = 1;
    public Rect(){
        super(212L);
    }

    public Long getInfo(){
        return super.getType();
    }

    public static void main(String[] args){
        Rect rect = new Rect();
        System.out.println(rect.getInfo());

        Shape<Long> shape = new Rect();
        System.out.println(((Rect) shape).getInfo());

        final int a;
        a = 10;

    }
}
