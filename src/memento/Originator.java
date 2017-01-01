package memento;

/**
 * Created by yangtianrui on 17-3-18.
 * 发起人角色
 */
public class Originator {

    // 模拟一个状态
    private String mState;

    public Originator(String state) {
        mState = state;
    }


    public void setState(String state) {
        mState = state;
    }

    public Memento createMemento() {
        return new Memento(mState);
    }

    // 输出状态
    public void printState() {
        System.out.println(mState);
    }
}
