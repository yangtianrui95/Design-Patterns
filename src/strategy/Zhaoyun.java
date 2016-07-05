package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * <p>
 * 赵云负责执行
 * <p>
 * 使用组合的方法，持有策略
 */
public class Zhaoyun {

    private Context mContext;

    public Zhaoyun(Context mContext) {
        this.mContext = mContext;
    }

    public Zhaoyun() {
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 赵云执行锦囊
     */
    public void operate() {
        mContext.operate();
    }
}
