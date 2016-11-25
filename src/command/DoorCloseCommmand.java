package command;

/**
 * Created by yangtianrui on 16-9-27.
 */
public class DoorCloseCommmand implements ICommand {
    private Door mDoor;

    public DoorCloseCommmand(Door door) {
        this.mDoor = door;
    }

    @Override
    public void execute() {
        mDoor.close();
    }
}
