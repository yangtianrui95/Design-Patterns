package template;

/**
 * Created by yangtianrui on 16-10-8.
 */
public class Main {
    public static void main(String[] args) {
        // 调用模板方法1
        ContreteClass contreteClass = new ContreteClass();
        contreteClass.commonOperation();

        System.out.println();

        // 调用模板方法2
        ContreteClass2 contreteClass2 = new ContreteClass2();
        contreteClass2.commonOperation();
    }
}
