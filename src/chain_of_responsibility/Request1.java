package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 */
public class Request1 extends BaseRequest {


    public Request1(String content) {
        super(content);
    }

    @Override
    public int getLevel() {
        return Level.LEVEL1;
    }
}
