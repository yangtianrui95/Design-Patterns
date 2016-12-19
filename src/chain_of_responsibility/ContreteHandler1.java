package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 */
public class ContreteHandler1 extends AbsHandler {
    @Override
    public int getHandleLevel() {
        return Level.LEVEL2;
    }

    @Override
    public void handle(BaseRequest request) {
        System.out.println("ContreteHandler1 #handle()");
    }
}
