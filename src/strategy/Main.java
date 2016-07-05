package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * <p>
 * 场景：刘备来吴国相亲了
 */
public class Main {
    public static void main(String[] args) {
        // 初始化武将赵云
        Zhaoyun zhaoyun = new Zhaoyun();

        // 拆开第一个锦囊
        zhaoyun.setContext(new Context(new BackDoor()));
        // 执行
        zhaoyun.operate();

        // 拆开第二个锦囊
        zhaoyun.setContext(new Context(new GreenLight()));
        // 执行
        zhaoyun.operate();

        // 拆开第三个锦囊
        zhaoyun.setContext(new Context(new BackEnemy()));
        // 执行
        zhaoyun.operate();
    }
}
//  执行结果:
//  找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备...
//  求吴国太开个绿灯，放行！
//  孙夫人断后，挡住追兵...
