package decorator_example;

/**
 * Created by yangtianrui on 16-8-21.
 * 装备的装饰器
 */
public interface IEquip {
    // 计算装备攻击力
    int calculateAttack();

    // 装备描述
    String description();
}
