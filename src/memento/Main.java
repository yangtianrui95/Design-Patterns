package memento;

/**
 * Created by yangtianrui on 17-3-18.
 */
public class Main {

    public static void main(String[] args) {
        // 初始化状态
        final Originator originator = new Originator("Initial state.");

        originator.printState();
        // 使用CareTaker保存状态

        final CareTaker careTaker = new CareTaker(originator.createMemento());

        // 修改状态
        originator.setState("Modify this state.");

        // 输出修改后的状态
        originator.printState();

        // 使用Memento恢复状态
        originator.setState(careTaker.retrieveState());

        // 输出恢复的状态
        originator.printState();

        /*结果
          Initial state.
          Modify this state.
          Initial state.
         */
    }
}
