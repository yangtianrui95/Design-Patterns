package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * ������Ե�ʵ�֣�
 * <p>
 * �����̫�����̵ƣ����У�
 */
public class GreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("�����̫�����̵ƣ����У�");
    }
}
