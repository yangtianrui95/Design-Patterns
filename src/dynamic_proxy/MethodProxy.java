package dynamic_proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yangtianrui on 16-7-30.
 * 方法代理类,基于反射实现动态代理
 */
public class MethodProxy {

    private Class clazz;   // 对象所属的类
    private Object target; // 目标对象
    private Method method; // 目标方法
    private Object[] params; // 参数数组

    public MethodProxy(Object target, String methodName, Object... params) {
        rebindTarget(target, methodName, params);
    }

    /**
     * 设置目标对象与方法
     */
    private void rebindTarget(Object target, String methodName, Object... params) {
        this.target = target;
        this.clazz = target.getClass();
        // 设置目标方法
        rebindMethod(methodName, params);
    }

    /**
     * 设置目标方法
     */
    private void rebindMethod(String methodName, Object... params) {
        this.params = params;
        int paramsLength = params.length;
        Class[] paramsType = new Class[paramsLength];
        // 获取每个参数的类型
        for (int i = 0; i < paramsLength; i++) {
            paramsType[i] = params[i].getClass();
        }
        try {
            this.method = clazz.getMethod(methodName, paramsType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用已经绑定的方法
     */
    public void doMethod() {
        try {
            this.method.invoke(target, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
