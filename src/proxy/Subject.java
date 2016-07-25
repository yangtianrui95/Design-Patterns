package proxy;

/**
 * Created by yangtianrui on 16-7-25.
 * <p>
 * 通过接口定义一个被代理类的规范
 */
interface Subject {
    void request();     // do something...

    Subject getProxy(); // 获取自身代理的对象
}
