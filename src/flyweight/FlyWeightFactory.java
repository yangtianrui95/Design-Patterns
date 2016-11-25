package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangtianrui on 16-10-11.
 * 享元工厂,为单例模式
 */
public class FlyWeightFactory {

    private Map<String, AbsFlyWeight> mFlyWeightPool = new HashMap<>();
    private static FlyWeightFactory sInstance;


    // 获取享元对象
    public AbsFlyWeight getFlyWeight(String type) {
        AbsFlyWeight flyWeight = null;
        if (mFlyWeightPool.containsKey(type)) {
            flyWeight = mFlyWeightPool.get(type);
        } else {
            flyWeight = new FlyWeight(type);
            mFlyWeightPool.put(type, flyWeight);
        }
        return flyWeight;
    }

    public static FlyWeightFactory getInstance() {
        if (sInstance == null) {
            synchronized (FlyWeightFactory.class) {
                if (sInstance == null) {
                    sInstance = new FlyWeightFactory();
                }
            }
        }
        return sInstance;
    }

}
