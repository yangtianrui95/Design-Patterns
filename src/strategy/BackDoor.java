package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * <p>
 * 具体策略的实现
 * 找乔国老帮忙，使孙权不能杀刘备。
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备...");
    }
}
