package memento.black_box_menento;

/**
 * Created by yangtianrui on 17-3-18.
 */
public class CareTaker {

    // 对外部只是表现为接口,体现了封装性
    private IMemento mMemento;

    public void setMemento(IMemento memento) {
        mMemento = memento;
    }


    public IMemento getMemento() {
        return mMemento;
    }


}
