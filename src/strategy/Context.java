package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * <p>
 * 用于存放锦囊的容器类
 */
public class Context {
    private IStrategy mStrategy;


    public Context(IStrategy mStrategy) {
        this.mStrategy = mStrategy;
    }

    public void operate() {
        mStrategy.operate();
    }
}
