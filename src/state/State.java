package state;

/**
 * Created by yangtianrui on 16-11-25.
 * 表示宾馆管理的三个状态
 */

public interface State {

    // 进入宾馆
    void checkInState();

    // 有人入住
    void usingState();

    // 离开宾馆
    void checkoutState();

}
