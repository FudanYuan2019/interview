package javalearning.abstractTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: Jeremy
 * @Date: 2019/5/22 19:55
 */
public class Shape {
    public String type;

    public Shape(String type){
        this.type = type;
    }

    public int Shape(){
        return 1;
    }

    public String getType(){
        return this.type;
    }

    public double calPerimeter(){
        return 0.0;
    }

    public int getLen(){
        return 10;
    }

    public static void main(String[] args) throws Exception{
        Shape shape = new Shape("Rect");
        Class<Shape> clazz = Shape.class;
        System.out.println(clazz == shape.getClass());

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println();

        try {
            System.out.println(Class.forName("javalearning.abstractTest.Shape"));
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println();


        Method[] methods = shape.getClass().getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println();

        try {
            Constructor constructor = Shape.class.getConstructor(String.class);
            System.out.println(constructor.toString());
            Shape shape1 = (Shape) constructor.newInstance("shape");
            System.out.println(shape1);
            System.out.println(shape1.getType());
        } catch (NoSuchMethodException e){
            System.out.println(e.getMessage());
        }

        Object o=new Object(){
            @Override
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));

        short a =128;
        byte b =(byte) a;
        System.out.println(a + " " + b);

//        String s;
//        System.out.println("s="+s);

        Runnable r = (Runnable) () -> {
          for (int i=0; i<10; i++){
              System.out.println(i);
          }
        };
        r.run();

        System.out.println(new Shape("21").Shape());

        double d1=-0.5;
        System.out.println("Ceil d1="+Math.ceil(d1));
        System.out.println("floor d1="+Math.floor(d1));
    }
}