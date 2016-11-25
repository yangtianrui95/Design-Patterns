package state;

/**
 * Created by yangtianrui on 16-11-25.
 * 已经有人预订的状态
 */
public class BookState implements State {
    @Override
    public void checkInState() {
        System.out.println("已经有人预订了");
    }

    @Override
    public void usingState() {
        System.out.println("开始使用");
    }

    @Override
    public void checkoutState() {
        System.out.println("退房成功");
    }
}
