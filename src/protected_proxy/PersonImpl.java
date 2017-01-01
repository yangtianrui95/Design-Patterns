package protected_proxy;

/**
 * Created by yangtianrui on 16-12-31.
 */
public class PersonImpl implements IPersonBean {

    private String name;
    private String gender;
    private int hotRating;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int getHotRating() {
        return hotRating;
    }

    @Override
    public void setHotRating(int hotRating) {
        this.hotRating = hotRating;
    }
}
