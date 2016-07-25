package proxy;

/**
 * Created by yangtianrui on 16-7-25.
 * 代理类
 */
public class Proxy implements Subject {
    private Subject mSubject; // 被代理类


    /**
     * 必须传递被代理的对象
     */
    public Proxy(Subject subject) {
        this.mSubject = subject;
    }

    @Override
    public void request() {
        // 让代理类去执行
        mSubject.request();
    }

    @Override
    public Subject getProxy() {
        return mSubject;
    }
}
