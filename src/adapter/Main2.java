package adapter;

/**
 * Created by yangtianrui on 16-9-28.
 * 适配器实现方法: 对象适配器
 */
public class Main2 {
    public static void main(String[] args) {
        Target2 target2 = new Adapter2(new Adaptee2());
        target2.request();
    }
}


interface Target2 {
    void request(); // 需要适配的方法
}


class Adaptee2 {
    void sampleMethod() {
        System.out.println("Adaptee sampleMethod");
    }
}


/**
 * 使用代理的方法,实现适配
 */
class Adapter2 extends Adaptee2 implements Target2 {

    private Adaptee2 adaptee2;

    public Adaptee2 getAdaptee2() {
        return adaptee2;
    }

    public void setAdaptee2(Adaptee2 adaptee2) {
        this.adaptee2 = adaptee2;
    }

    public Adapter2(Adaptee2 adaptee2) {
        this.adaptee2 = adaptee2;
    }

    @Override
    public void request() {
        adaptee2.sampleMethod();
    }
}