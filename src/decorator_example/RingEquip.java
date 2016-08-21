package decorator_example;

/**
 * Created by yangtianrui on 16-8-21.
 */
public class RingEquip implements IEquip {
    @Override
    public int calculateAttack() {
        return 10;
    }

    @Override
    public String description() {
        return "这是一个戒指,加10点攻击力";
    }
}
