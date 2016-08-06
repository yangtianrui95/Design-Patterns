package decorator;

/**
 * Created by yangtianrui on 16-8-7.
 * 具体业务的装饰器类
 */
public class RedBoundShape extends DecoratorShape {
    public RedBoundShape(Shape shape) {
        super(shape);
    }


    @Override
    public void draw() {
        super.draw();
        // 其他业务.....
        System.out.println("This shape is Red Bound");
    }
}
