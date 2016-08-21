package decorator_example;

/**
 * Created by yangtianrui on 16-8-21.
 * 红宝石  用于镶嵌在武器上增加攻击力
 */
public class RedGemDecorator implements IEquipDecorator {
    // 要镶嵌的装备
    private IEquip equip;

    @Override
    public int calculateAttack() {
        return equip.calculateAttack() + 5;
    }

    @Override
    public String description() {
        return equip.description() + "红宝石增加5点攻击力";
    }

    public RedGemDecorator(IEquip equip) {
        this.equip = equip;
    }
}
