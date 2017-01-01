package protected_proxy;

/**
 * Created by yangtianrui on 16-12-31.
 */
public interface IPersonBean {

    String getName();

    String getGender();

    int getHotRating();

    void setName(String name);

    void setGender(String name);

    // 将使用代理限制这个方法的访问
    void setHotRating(int rating);

}
