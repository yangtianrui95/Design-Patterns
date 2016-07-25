package proxy;

/**
 * Created by yangtianrui on 16-7-25.
 */
public class Main {
    public static void main(String[] args) {
        // 代理一个RealSubject对象
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request(); // 实际上时RealSubject对象的request()执行
        // 输出:RealSubject   --->   request()
    }
}
