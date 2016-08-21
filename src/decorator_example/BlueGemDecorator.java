package decorator_example;

/**
 * Created by yangtianrui on 16-8-21.
 * 蓝宝石 增加7点攻击力
 */
public class BlueGemDecorator implements IEquipDecorator {
    private IEquip equip;

    @Override
    public int calculateAttack() {
        return equip.calculateAttack() + 7;
    }

    @Override
    public String description() {
        return equip.description() + "蓝宝石 增加7点攻击力";
    }

    public BlueGemDecorator(IEquip equip) {
        this.equip = equip;
    }
}
