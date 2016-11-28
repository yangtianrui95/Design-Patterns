package bridge;

/**
 * Created by yangtianrui on 16-11-28.
 * 具体实现类
 */
public class ContreteDisplay implements DisplayImpl {
    @Override
    public void rawOpen() {
        System.out.println("ContreteDisplay #rawOpen()");
    }

    @Override
    public void rawPrint() {
        System.out.println("ContreteDisplay #rawPrint()");
    }

    @Override
    public void rawClose() {
        System.out.println("ContreteDisplay #rawClose()");
    }
}
