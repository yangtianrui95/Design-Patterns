package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * 具体策略的实现：
 * <p>
 * 求吴国太开个绿灯，放行！
 */
public class GreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行！");
    }
}
