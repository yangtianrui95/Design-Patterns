package flyweight;

/**
 * Created by yangtianrui on 16-10-11.
 */
public class Main {
    public static void main(String[] args) {
        AbsFlyWeight flyWeight1 = FlyWeightFactory.getInstance().getFlyWeight("Baidu");
        AbsFlyWeight flyWeight2 = FlyWeightFactory.getInstance().getFlyWeight("NetEase");
        AbsFlyWeight flyWeight3 = FlyWeightFactory.getInstance().getFlyWeight("Sina");
        AbsFlyWeight flyWeight4 = FlyWeightFactory.getInstance().getFlyWeight("Baidu");
        AbsFlyWeight flyWeight5 = new FlyWeight("Baidu");

        flyWeight1.operation();
        flyWeight2.operation();
        flyWeight3.operation();
        flyWeight4.operation();
        flyWeight5.operation(); // 不是同一个对象
    }
}
