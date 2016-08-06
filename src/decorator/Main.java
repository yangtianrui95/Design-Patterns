package decorator;

/**
 * Created by yangtianrui on 16-8-7.
 */
public class Main {
    public static void main(String[] args) {
        Shape shape = new RedBoundShape(new Circle());
        Shape shape2 = new RedBoundShape(new Reac());
        shape.draw();
        shape2.draw();
        // 结果
//        Shape : Circle
//        This shape is Red Bound
//        Shape : Reac
//        This shape is Red Bound
    }
}
