package javalearning.generic;

/**
 * @Author: Jeremy
 * @Date: 2019/5/21 10:44
 */
class Shape<T extends Number>{
    private T type;

    public Shape(){
    }

    public Shape(T type){
        this.type = type;
    }

    public T getType(){
        return this.type;
    }

    public void setType(T type){
        this.type = type;
    }

    public static void main(String[] args){

        Shape<Integer> shape1 = new Shape<Integer>(1);
        System.out.println(shape1.getType());

        Shape<Double> shape = new Shape<Double>(2.0D);
        System.out.println(shape.getType());

        Shape<Integer> shape2 = new Shape<Integer>();
        System.out.println(shape2.getType());
    }
}
