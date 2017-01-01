package protected_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yangtianrui on 16-12-31.
 * 这个代理类对执行的方法不做任何保护
 */
public class PubInvocationHandler implements InvocationHandler {

    private IPersonBean person;

    public PubInvocationHandler(IPersonBean person) {
        this.person = person;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            method.invoke(person, args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
