package decorator_example;

/**
 * Created by yangtianrui on 16-8-21.
 */
public class Main {
    public static void main(String[] args) {
        // 一个镶嵌红宝石的武器
        IEquip armEquip = new RedGemDecorator(new ArmEuqip());

        // 一个镶嵌蓝宝石的戒指
        IEquip ringEquip = new BlueGemDecorator(new RingEquip());

        //  一个镶嵌红蓝宝石的武器
        IEquip armEquip2 = new RedGemDecorator(new BlueGemDecorator(new ArmEuqip()));

        // for test
        System.out.println(armEquip.description());
        System.out.println(ringEquip.description());
        System.out.println(armEquip2.description());
//        这是一个武器,附加20点攻击力红宝石增加5点攻击力
//        这是一个戒指,加10点攻击力蓝宝石 增加7点攻击力
//        这是一个武器,附加20点攻击力蓝宝石 增加7点攻击力红宝石增加5点攻击力
    }
}
