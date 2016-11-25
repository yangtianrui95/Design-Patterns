package state;

/**
 * Created by yangtianrui on 16-11-25.
 * 尚未预订的状态
 */
public class FreeState implements State {

    @Override
    public void checkInState() {
        System.out.println("尚未预订");
    }

    @Override
    public void usingState() {
        System.out.println("尚未预订");
    }

    @Override
    public void checkoutState() {
        System.out.println("房间还未时使用");
    }
}
