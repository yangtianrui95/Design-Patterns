package template;

/**
 * Created by yangtianrui on 16-10-8.
 * 具体子类,但是模板算法不变
 */
public class ContreteClass extends AbsPrimativeClass {

    @Override
    void beforeOperation() {
        System.out.println(this.getClass().getSimpleName() + " beforeOperation");
    }

    @Override
    void afterOperation() {
        System.out.println(this.getClass().getSimpleName() + " alterOperation");
    }


    // 调用高层组件
    @Override
    protected boolean conditionOperation() {
        return true;
    }
}
