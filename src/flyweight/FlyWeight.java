package flyweight;

/**
 * Created by yangtianrui on 16-10-11.
 */
public class FlyWeight extends AbsFlyWeight {

    private String type;

    public FlyWeight(String type) {
        this.type = type;
    }

    @Override
    public void operation() {
        System.out.println(type + "  operation" + hashCode());
    }
}
