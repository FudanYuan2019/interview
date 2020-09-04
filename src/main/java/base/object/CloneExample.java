package base.object;

/**
 * @Author: Jeremy
 * @Date: 2020/2/10 10:34
 */
public class CloneExample implements Cloneable {
    private int x;
    private int y;

    public CloneExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + this.x + ", y=" + this.y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        CloneExample cloneExample = new CloneExample(10, 10);
        try {
            CloneExample cloneExample2 = (CloneExample) cloneExample.clone();
            System.out.println(cloneExample2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
