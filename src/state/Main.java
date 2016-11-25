package state;

/**
 * Created by yangtianrui on 16-11-25.
 */
public class Main {

    public static void main(String[] args) {
        HotelManager manager = new HotelManager();
        // 此处为预订
        manager.checkInHotel();

        // 预订宾馆, Manager 会切换不同的State对象
        manager.bookHotel();

        // 再次预订宾馆
        manager.checkInHotel();

        // 结果:
        // 尚未预订
        // 开始使用
        // 已经有人预订了
    }
}
