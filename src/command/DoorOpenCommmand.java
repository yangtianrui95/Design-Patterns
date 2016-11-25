package command;

/**
 * Created by yangtianrui on 16-9-27.
 * 实体命令类
 */
public class DoorOpenCommmand implements ICommand {

    private Door mDoor;// 命令要操作的对象(Receiver)

    public DoorOpenCommmand(Door door) {
        this.mDoor = door;
    }

    @Override
    public void execute() {
        mDoor.open();
    }
}
