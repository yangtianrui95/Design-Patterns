package command;

/**
 * Created by yangtianrui on 16-9-27.
 * 对命令进行汇总,汇总后进行控制
 */
public class ControlPanel {
    private ICommand[] commands = new ICommand[2];

    public ControlPanel() {
        for (int i = 0; i < commands.length; i++) {
            commands[i] = new NoCommand();
        }
    }

    public void setCommmand(int index, ICommand command) {
        commands[index] = command;
    }

    public void executeCommand(int index) {
        commands[index].execute();
    }

}
