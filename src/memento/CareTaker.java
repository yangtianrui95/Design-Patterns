package memento;

/**
 * Created by yangtianrui on 17-3-18.
 * 负责人角色,负责人保存对象状态
 */
public class CareTaker {

    private Memento mMemento;


    public CareTaker(Memento memento) {
        mMemento = memento;
    }

    /**
     * 获取状态
     */
    public String retrieveState() {
        return mMemento.getState();
    }

    /**
     * 存入状态
     */
    public void saveState(Memento memento) {
        mMemento = memento;
    }
}
