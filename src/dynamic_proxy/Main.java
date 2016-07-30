package dynamic_proxy;

/**
 * Created by yangtianrui on 16-7-30.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        // 代理无参数的方法
        MethodProxy methodProxy = new MethodProxy(person, "say");
        methodProxy.doMethod();
        // Say SomeThing...

        // 代理有参数的方法
        MethodProxy proxy2 = new MethodProxy(person, "love", "hehe");
        proxy2.doMethod();
        // I love hehe
    }
}
