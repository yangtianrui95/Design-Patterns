package decorator;

/**
 * Created by yangtianrui on 16-8-7.
 * 抽象业务的装饰器类
 */
public abstract class DecoratorShape implements Shape {
    private Shape mShape; // 具体的业务对象

    public DecoratorShape(Shape shape) {
        mShape = shape;
    }

    @Override
    public void draw() {
        mShape.draw();
    }
}
