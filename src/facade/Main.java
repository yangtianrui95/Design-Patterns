package facade;

/**
 * Created by yangtianrui on 16-9-29.
 */
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        // 使用命令模式对子模块进行封住
        // 移除子模块只需修改外观即可
        facade.doMethod();
    }
}
