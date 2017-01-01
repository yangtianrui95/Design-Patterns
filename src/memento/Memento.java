package memento;

/**
 * Created by yangtianrui on 17-3-18.
 * 备忘录对象,用来存储Originator的状态
 */
public class Memento {

    private String mState;

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Memento(String state) {
        mState = state;
    }
}
