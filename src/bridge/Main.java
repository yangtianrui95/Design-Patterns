package bridge;

/**
 * Created by yangtianrui on 16-11-28.
 */
public class Main {

    public static void main(String[] args) {
        Display display = new Display();

        // 这里调用impl具体对象的实现
        display.open();
        display.print();
        display.close();
//        Display #open()
//        ContreteDisplay #rawOpen()
//        Display #print()
//        ContreteDisplay #rawPrint()
//        Display #close()
//        ContreteDisplay #rawClose()
    }
}
