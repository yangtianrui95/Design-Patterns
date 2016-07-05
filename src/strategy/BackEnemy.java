package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * 具体策略的实现：
 * <p>
 * 孙夫人断后，挡住追兵。
 */
public class BackEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵...");
    }
}
