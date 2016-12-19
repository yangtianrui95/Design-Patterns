package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 */
public class Request3 extends BaseRequest {


    public Request3(String content) {
        super(content);
    }

    @Override
    public int getLevel() {
        return Level.LEVEL3;
    }
}
