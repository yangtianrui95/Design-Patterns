package facade;

/**
 * Created by yangtianrui on 16-9-29.
 * 使用外观模式对子模块进行封装
 */
public class Facade {
    private SubSystemA systemA = new SubSystemA();
    private SubSystemB systemB = new SubSystemB();


    public void doMethod() {
        systemA.methodA();
        systemB.methodB();
    }
}
