package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * <p>
 * ���Ƹ���ִ��
 * <p>
 * ʹ����ϵķ��������в���
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
     * ����ִ�н���
     */
    public void operate() {
        mContext.operate();
    }
}
