package state;

/**
 * Created by yangtianrui on 16-11-25.
 * Context for State interface.
 */
public class HotelManager {
    private State mCurState = new FreeState(); // 当前的状态值

    // 预订一个宾馆,设置对应的状态值
    // 此处为改变状态对象
    public void bookHotel() {
        mCurState = new BookState();
        mCurState.usingState();
    }

    public void checkInHotel() {
        mCurState.checkInState();
    }

    public void checkoutHotel() {
        mCurState.checkoutState();
    }


    public State getState() {
        return mCurState;
    }


    public void setState(State mCurState) {
        this.mCurState = mCurState;
    }


}
