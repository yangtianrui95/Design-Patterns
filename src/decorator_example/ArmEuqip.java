package decorator_example;

/**
 * Created by yangtianrui on 16-8-21.
 * 武器
 */
public class ArmEuqip implements IEquip {
    @Override
    public int calculateAttack() {
        return 20; // 加20点攻击力
    }

    @Override
    public String description() {
        return "这是一个武器,附加20点攻击力";
    }
}
