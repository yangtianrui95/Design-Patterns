package memento.black_box_menento;

/**
 * Created by yangtianrui on 17-3-18.
 */
public class Originator {

    // 模拟保存的状态
    private String mState;

    public Originator(String state) {
        mState = state;
    }

    public void setState(String state) {
        mState = state;
    }

    public void printState() {
        System.out.println(mState);
    }


    // 创建备忘录保存对象
    public IMemento createMemento() {
        // 保存对象
        return new OriginMemento(mState);
    }

    // 从备忘录中恢复状态
    public void restoreMemento(IMemento memento) {
        if (memento instanceof OriginMemento) {
            mState = ((OriginMemento) memento).getState();
        }
    }


    /**
     * 通过内部类,将对象状态进行封装
     */
    private class OriginMemento implements IMemento {
        private String mState;

        public OriginMemento(String state) {
            mState = state;
        }

        public String getState() {
            return mState;
        }

        public void setState(String state) {
            mState = state;
        }
    }
}
