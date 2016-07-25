package proxy;

/**
 * Created by yangtianrui on 16-7-25.
 * 被代理类
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject   --->   request() ");
    }

    @Override
    public Subject getProxy() {
        return null; // 没有代理任何对象
    }
}
