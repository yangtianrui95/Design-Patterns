package chain_of_responsibility;

/**
 * Created by yangtianrui on 16-12-20.
 */
public class Main {

    public static void main(String[] args) {
        AbsHandler handler = new ContreteHandler1();
        AbsHandler handler2 = new ContreteHandler2();

        Request1 request1 = new Request1("request1 ");
        Request2 request2 = new Request2("request2 ");
        Request3 request3 = new Request3("request3 ");

        handler.setNextHandler(handler2);

        handler.handleRequest(request1);
        handler.handleRequest(request2);
        // 让下级进行处理
        handler.handleRequest(request3);

        /*
            结果
            ContreteHandler1 #handle()
            ContreteHandler1 #handle()
            ContreteHandler1 can 't handle this request!
            ContreteHandler2 #handle()
        */
    }
}
