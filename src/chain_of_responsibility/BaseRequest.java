package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 * 模拟各种请求
 */
public abstract class BaseRequest {

    private String content; // 要传递修改的内容

    public BaseRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // 根据级别进行判断
    abstract public int getLevel();
}
