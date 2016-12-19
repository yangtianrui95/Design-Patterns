package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 * 请求处理类
 */
public abstract class AbsHandler {
    // 指向职责链的下一个引用
    private AbsHandler mNextHandler;

    public final void handleRequest(BaseRequest request) {
        // 可以处理
        if (getHandleLevel() >= request.getLevel()) {
            // 在当前处理
            handle(request);
        } else {
            System.out.println(getClass().getSimpleName() + " can 't handle this request!");
            // 无法处理时
            // 向下传递处理
            mNextHandler.handleRequest(request);
        }
    }

    public void setNextHandler(AbsHandler nextHandler) {
        mNextHandler = nextHandler;
    }

    abstract public int getHandleLevel();

    abstract protected void handle(BaseRequest request);
}
