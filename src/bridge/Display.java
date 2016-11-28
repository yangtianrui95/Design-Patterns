package bridge;

/**
 * Created by yangtianrui on 16-11-28.
 * 这个类既包含抽象又包含具体实现,使用DisplayImpl对象进行桥接,实现解偶
 */
public class Display {
    // 使用桥接,将抽象与具体实现解偶
    private DisplayImpl mDisplay = new ContreteDisplay();

    public void open() {
        System.out.println("Display #open()");
        mDisplay.rawOpen();
    }

    public void print() {
        System.out.println("Display #print()");
        mDisplay.rawPrint();
    }

    public void close() {
        System.out.println("Display #close()");
        mDisplay.rawClose();
    }

}
