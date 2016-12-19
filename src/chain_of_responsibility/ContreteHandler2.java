package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 */
public class ContreteHandler2 extends AbsHandler {
    @Override
    public int getHandleLevel() {
        return Level.LEVEL3;
    }

    @Override
    public void handle(BaseRequest request) {
        String content = request.getContent();
    }
}
