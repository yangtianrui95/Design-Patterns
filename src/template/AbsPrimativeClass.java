package template;

/**
 * Created by yangtianrui on 16-10-8.
 * 模板类
 */
abstract public class AbsPrimativeClass {

    // 子类中通用的操作
    public final void commonOperation() {
        beforeOperation();
        System.out.println("Common Operation");
        afterOperation();
        if (conditionOperation()) {
            System.out.println("Hook this Operation by condition method");
        }
    }


    // 每个子类中不一样,须在子类中实现的方法

    abstract void beforeOperation();

    abstract void afterOperation();

    // 底层模块中的钩子,供高层模块之间选择调用
    protected boolean conditionOperation() {
        return false;
    }

}
