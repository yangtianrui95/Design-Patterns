package protected_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yangtianrui on 16-12-31.
 * 使用JDK提供的方法实现动态代理
 * 对真实调用对象提供保护
 */
public class ProtectInvocationHandler implements InvocationHandler {
    private IPersonBean person;

    public ProtectInvocationHandler(IPersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            // 执行所有getter
            if (method.getName().startsWith("get")) {
                method.invoke(person, args);
                // 对setHotRating进行权限管理
            } else if (method.getName().equals("setHotRating")) {
                System.out.println("yon don't have permission to invoke this method!!");
            } else if (method.getName().startsWith("set")) {
                method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            // 真正的主题抛出异常,在此处进行处理
            e.printStackTrace();
        }
        return null;
    }
}
