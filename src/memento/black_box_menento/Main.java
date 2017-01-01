package memento.black_box_menento;

/**
 * Created by yangtianrui on 17-3-18.
 */
public class Main {

    public static void main(String[] args) {

        // 初始状态
        final Originator originator = new Originator("Initial state.");
        originator.printState();

        // 存储状态到备忘录
        final CareTaker careTaker = new CareTaker();
        careTaker.setMemento(originator.createMemento());

        // 更改状态
        originator.setState("Modified state.");
        originator.printState();

        // 恢复状态
        originator.restoreMemento(careTaker.getMemento());
        originator.printState();


        /*
          结果
         *Initial state.
         *Modified state.
         *Initial state.
         */
    }
}
