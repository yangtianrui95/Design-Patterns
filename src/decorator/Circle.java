package decorator;

/**
 * Created by yangtianrui on 16-8-7.
 * 具体业务类
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape : Circle");
    }
}
