package command;

/**
 * Created by yangtianrui on 16-9-27.
 */
public class Main {
    public static void main(String[] args) {
        ControlPanel panel = new ControlPanel();

        Door door = new Door();
        panel.setCommmand(0, new DoorCloseCommmand(door));
        panel.setCommmand(1, new DoorOpenCommmand(door));

        panel.executeCommand(0);
        panel.executeCommand(1);
    }
}
