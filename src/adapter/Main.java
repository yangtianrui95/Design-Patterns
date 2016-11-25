package adapter;

/**
 * Created by yangtianrui on 16-9-28.
 * 适配器实现方法: 类适配器
 */
public class Main {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request(); // 调用需要进行适配的方法
    }
}


/**
 * 源接口,需进行适配的接口
 */
class Adaptee {
    public void simpleMethod() {
        System.out.println("Adaptee 这是需要适配的方法");
    }
}


/**
 * 目标接口,需适配完成的接口
 */
interface Target {
    void request();
}

/**
 * 适配器类,目标接口改变时 只需改变适配器类
 */
class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        System.out.println("Target  Adapter处理Target类中的方法");
    }
}