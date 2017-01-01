package protected_proxy;

import java.lang.reflect.Proxy;

/**
 * Created by yangtianrui on 16-12-31.
 */
public class Main {

    public static void main(String[] args) {
        // 保护的代理对象
        IPersonBean protectPerson = new PersonImpl();
        IPersonBean protectProxy = getProtectProxy(protectPerson);

        // 普通代理对象
        IPersonBean pubPerson = new PersonImpl();
        IPersonBean pubProxy = getPubProxy(pubPerson);


        // 访问受保护的代理对象
        protectProxy.setName("AAA");
        protectProxy.setHotRating(100);
        // yon don't have permission to invoke this method!!


        // 访问普通代理对象
        pubProxy.setName("BBB");
        pubProxy.setHotRating(90);


    }

    /**
     * 创建保护的动态代理
     *
     * @param protectPerson
     */
    private static IPersonBean getProtectProxy(IPersonBean protectPerson) {
        return (IPersonBean) Proxy.newProxyInstance(protectPerson.getClass().getClassLoader()
                , protectPerson.getClass().getInterfaces(), new ProtectInvocationHandler(protectPerson));
    }


    /**
     * 创建公共的动态代理
     */
    private static IPersonBean getPubProxy(IPersonBean pubPerson) {
        return (IPersonBean) Proxy.newProxyInstance(pubPerson.getClass().getClassLoader()
                , pubPerson.getClass().getInterfaces(), new PubInvocationHandler(pubPerson));
    }

}
