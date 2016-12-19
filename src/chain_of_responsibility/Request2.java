package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 */
public class Request2 extends BaseRequest {


    public Request2(String content) {
        super(content);
    }

    @Override
    public int getLevel() {
        return Level.LEVEL2;
    }
}
